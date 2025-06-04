package com.multitap.feedbackquery.entity;

import com.multitap.feedbackquery.dto.in.FeedbackScoreContentDto;
import com.multitap.feedbackquery.dto.in.FeedbackScoreRequestDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
@CompoundIndex(name = "user_category_index", def = "{'id': 1, 'feedbackScores.categoryCode': 1}")
public class FeedbackRecord {

    @Id
    private String id;
    private List<FeedbackScoreRequestDto> feedbackScore;
    private List<FeedbackScoreContentDto> feedbackContent;

}
