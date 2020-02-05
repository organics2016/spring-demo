package ink.organics.demo.rabbitmq;


import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Profile("dev")
@Component
public class Consume {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("test_queue_delayed"),
            exchange = @Exchange(
                    value = "test_delayed",
                    delayed = Exchange.TRUE
            ),
            key = "test_delayed_routing_key"
    ))
    public void processMessage(String content) {

        System.out.println("processMessage");
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(content);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("queue2"),
            exchange = @Exchange("test_test"),
            key = "test2_routing_key"
    ))
    public void processMessage2(String content) {
        System.out.println("processMessage2");
        System.out.println(content);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("queue3"),
            exchange = @Exchange( "test_test"),
            key = "test3_routing_key"
    ))
    public void processMessage3(String content) {
        System.out.println("processMessage3");
        System.out.println(content);
    }
}
