package ink.organics.demo.eureka.feign.client;

import com.alibaba.fastjson.JSONObject;
import ink.organics.demo.eureka.feign.client.api.EurekaFeignServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaFeignClientTest {


    @Resource
    private EurekaFeignServer eurekaFeignServer;


    @Test
    public void test1() {
        ResponseEntity<JSONObject> entity = eurekaFeignServer.test1();
        System.out.println(entity);
        System.out.println(entity.getBody());
    }

}
