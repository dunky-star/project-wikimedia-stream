package com.wikisconsume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId="${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){
        
    }
}
