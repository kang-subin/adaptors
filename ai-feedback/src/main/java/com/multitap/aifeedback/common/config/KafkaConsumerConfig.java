package com.multitap.aifeedback.common.config;

import com.multitap.aifeedback.adaptor.in.kafka.messagein.FeedbackScorePromptDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
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
    public ConsumerFactory<String, FeedbackScorePromptDto> promptConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUri);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(FeedbackScorePromptDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FeedbackScorePromptDto> feedbackScorePromptDtoListener() {
        ConcurrentKafkaListenerContainerFactory<String, FeedbackScorePromptDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(promptConsumerFactory());
        return factory;
    }
}
