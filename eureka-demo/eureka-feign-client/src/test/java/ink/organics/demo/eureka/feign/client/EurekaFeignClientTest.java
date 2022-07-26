package ink.organics.demo.eureka.feign.client;

import com.alibaba.fastjson.JSONObject;
import ink.organics.demo.eureka.feign.client.api.EurekaFeignServerApi;
import ink.organics.demo.eureka.feign.client.dto.EurekaFeignServerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

@SpringBootTest
public class EurekaFeignClientTest {


    @Resource
    private EurekaFeignServerApi eurekaFeignServerApi;


    @Test
    public void test1() {
        ResponseEntity<JSONObject> entity = eurekaFeignServerApi.test1();
        System.out.println(entity);
    }

    @Test
    public void test2() {
        ResponseEntity<String> entity = eurekaFeignServerApi.test2();
        System.out.println(entity);
    }

    @Test
    public void test3() {
        ResponseEntity<EurekaFeignServerDTO> entity = eurekaFeignServerApi.test3();
        System.out.println(entity);
    }

    @Test
    public void test4() {
        JSONObject entity = eurekaFeignServerApi.test4();
        System.out.println(entity);
    }


    @Test
    public void test5() {
        String entity = eurekaFeignServerApi.test5();
        System.out.println(entity);
    }

    @Test
    public void test6() {
        EurekaFeignServerDTO entity = eurekaFeignServerApi.test6();
        System.out.println(entity);
    }
}
