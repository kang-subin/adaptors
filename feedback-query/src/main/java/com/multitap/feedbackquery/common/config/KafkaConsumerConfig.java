package com.multitap.feedbackquery.common.config;

import com.multitap.feedbackquery.kafka.consumer.messagein.FeedbackContentResponseVo;
import com.multitap.feedbackquery.kafka.consumer.messagein.FeedbackScoreDto;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${kafka.cluster.uri}")
    private String kafkaClusterUri;

    @Value("${kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, FeedbackScoreDto> feedbackScoreConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUri);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(FeedbackScoreDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FeedbackScoreDto> feedbackScoreDtoListener() {
        ConcurrentKafkaListenerContainerFactory<String, FeedbackScoreDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(feedbackScoreConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, FeedbackContentResponseVo> feedbackContentConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUri);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(FeedbackContentResponseVo.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FeedbackContentResponseVo> feedbackContentResponseVoListener() {
        ConcurrentKafkaListenerContainerFactory<String, FeedbackContentResponseVo> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(feedbackContentConsumerFactory());
        return factory;
    }
}
