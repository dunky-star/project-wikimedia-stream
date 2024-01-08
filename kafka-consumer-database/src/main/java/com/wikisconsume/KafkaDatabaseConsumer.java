package com.wikisconsume;

import com.wikisconsume.payload.WikimediaData;
import com.wikisconsume.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private final WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId="${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received -> %s", eventMessage));
        // Create object of WikimediaData to save WikiEventData to database
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        dataRepository.save(wikimediaData);
    }
}
