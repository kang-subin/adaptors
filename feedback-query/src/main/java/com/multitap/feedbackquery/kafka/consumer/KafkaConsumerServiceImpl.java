package com.multitap.feedbackquery.kafka.consumer;

import com.multitap.feedbackquery.dto.in.FeedbackScoreContentDto;
import com.multitap.feedbackquery.dto.in.FeedbackScoreRequestDto;
import com.multitap.feedbackquery.entity.FeedbackRecord;
import com.multitap.feedbackquery.infrastructure.FeedbackRecordRepository;
import com.multitap.feedbackquery.kafka.producer.AiFeedbackScoreDto;
import com.multitap.feedbackquery.kafka.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final FeedbackRecordRepository feedbackRecordRepository;
    private final KafkaProducerService kafkaProducerService;
    private final MongoTemplate mongoTemplate;

    @Override
    public void addFeedbackScore(FeedbackScoreRequestDto feedbackScoreRequestDto, String uuid) {

        Query query = new Query(Criteria.where("id").is(uuid));
        Update update = new Update();
        update.push("feedbackScore", feedbackScoreRequestDto);

        // feedbackScore 리스트에 새로운 스코어 추가
        mongoTemplate.upsert(query, update, FeedbackRecord.class);

        // feedback score -> ai feedback-service
        kafkaProducerService.sendCreateFeedbackScore(AiFeedbackScoreDto.from(feedbackRecordRepository.findFirstAndLastFeedbackScore(uuid, feedbackScoreRequestDto.getCategoryCode()), feedbackScoreRequestDto.getCategoryCode()));
    }

    @Override
    public void addFeedbackContent(FeedbackScoreContentDto feedbackScoreContentDto, String uuid) {
        log.info("카테고리 값: {}", feedbackScoreContentDto.getCategory());

        // 피드백의 ID와 카테고리가 일치하는 레코드를 찾기 위한 쿼리 생성
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(uuid));

        // 기존 레코드 조회
        FeedbackRecord existingRecord = mongoTemplate.findOne(query, FeedbackRecord.class);

        // 업데이트 쿼리 생성
        Query updateQuery = new Query();
        updateQuery.addCriteria(Criteria.where("id").is(uuid));

        // 업데이트 객체 생성
        Update update = new Update();

        if (existingRecord != null && existingRecord.getFeedbackContent() != null) {
            // 카테고리가 일치하는 피드백 내용이 있는지 확인
            boolean categoryExists = existingRecord.getFeedbackContent().stream()
                    .anyMatch(content -> content.getCategory().equals(feedbackScoreContentDto.getCategory()));

            if (categoryExists) {
                // 해당 카테고리가 이미 있으면 해당 항목만 업데이트
                update.set("feedbackContent.$[elem].content", feedbackScoreContentDto.getContent())
                        .filterArray(Criteria.where("elem.category").is(feedbackScoreContentDto.getCategory()));
            } else {
                // 해당 카테고리가 없으면 새로운 피드백 추가
                update.push("feedbackContent", feedbackScoreContentDto);
            }
        } else {
            // 기존 레코드가 없거나 feedbackContent가 null인 경우
            // feedbackContent 필드를 새로운 배열로 초기화
            update.set("feedbackContent", Arrays.asList(feedbackScoreContentDto));
        }

        // MongoDB에 업데이트 실행
        mongoTemplate.upsert(updateQuery, update, FeedbackRecord.class);
    }

}