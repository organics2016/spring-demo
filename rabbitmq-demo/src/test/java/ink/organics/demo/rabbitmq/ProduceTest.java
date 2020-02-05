package ink.organics.demo.rabbitmq;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduceTest {


    @Resource
    private Produce produce;


    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ffff");
        map.put("age", 555);
        produce.send(map, 2000);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
