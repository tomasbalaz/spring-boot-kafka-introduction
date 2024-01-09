package sk.balaz.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import sk.balaz.kafka.payload.Student;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "test", groupId = "consumer-group")
//    curl --location 'http://localhost:8080/api/v1/messages' \
//            --header 'Content-Type: text/plain' \
//            --data 'This my first message'
    public void consumeMessage(String message) {
        log.info( format("Consuming the message from test topic:: %s", message));
    }

    @KafkaListener(topics = "test", groupId = "consumer-group")
//    curl --location 'http://localhost:8080/api/v1/messages/json' \
//            --header 'Content-Type: application/json' \
//            --data '{
//            "id" : 3,
//            "firstName" : "marion",
//            "lastName" : "12345"
//}'
    public void consumeJsonMessage(Student student) {
        log.info( format("Consuming the student from test topic:: %s", student));
    }
}
