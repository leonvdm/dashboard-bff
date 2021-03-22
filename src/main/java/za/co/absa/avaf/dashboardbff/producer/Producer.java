package za.co.absa.avaf.dashboardbff.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "za.co.absa.avaf.asset";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String vehicle){
        this.kafkaTemplate.setDefaultTopic(TOPIC);
        logger.info(String.format("$$$ -> Producing message --> %s",vehicle));
        this.kafkaTemplate.sendDefault(LocalDateTime.now().toString(), vehicle);
    }
}
