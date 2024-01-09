package sk.balaz.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "consumer-group")
    public void consumeMessage(String message) {
        log.info( format("Consuming the message from test topic:: %s", message));
    }
}
