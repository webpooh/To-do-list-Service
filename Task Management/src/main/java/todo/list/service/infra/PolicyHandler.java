package todo.list.service.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import todo.list.service.config.kafka.KafkaProcessor;
import todo.list.service.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    TaskRepository taskRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TaskCreated'"
    )
    public void wheneverTaskCreated_TaskDueDatePolicy(
        @Payload TaskCreated taskCreated
    ) {
        TaskCreated event = taskCreated;
        System.out.println(
            "\n\n##### listener TaskDueDatePolicy : " + taskCreated + "\n\n"
        );

        // Sample Logic //
        Task.taskDueDatePolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TaskCreated'"
    )
    public void wheneverTaskCreated_TaskPriorityPolicy(
        @Payload TaskCreated taskCreated
    ) {
        TaskCreated event = taskCreated;
        System.out.println(
            "\n\n##### listener TaskPriorityPolicy : " + taskCreated + "\n\n"
        );

        // Sample Logic //
        Task.taskPriorityPolicy(event);
    }
}
