package sk.balaz.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import sk.balaz.kafka.payload.Student;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student message) {
        Message<Student> msg = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, "test")
                .build();

        kafkaTemplate.send(msg);
    }
}
