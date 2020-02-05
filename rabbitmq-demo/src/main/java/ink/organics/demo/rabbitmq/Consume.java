package ink.organics.demo.rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Consume {

    @RabbitListener(queues = "test_queue")
    public void processMessage(String content) {

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(content);

    }
}
