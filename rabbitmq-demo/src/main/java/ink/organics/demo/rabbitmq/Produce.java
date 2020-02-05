package ink.organics.demo.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class Produce {

    @Resource
    private RabbitTemplate rabbitTemplate;


    public void send(Object pojo, int delay) {

        Message message = MessageBuilder.withBody(JSON.toJSONBytes(pojo))
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setContentEncoding(StandardCharsets.UTF_8.name())
                .setMessageId(UUID.randomUUID().toString())
                .build();

        message.getMessageProperties().setDelay(delay);

        rabbitTemplate.convertAndSend("test_delayed", "test_routing_key", message);
    }
}
