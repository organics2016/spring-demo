package ink.organics.demo.eureka.feign.client.api;


import com.alibaba.fastjson.JSONObject;
import ink.organics.demo.eureka.feign.client.dto.EurekaFeignServerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "EurekaFeignServer", path = "/feign/server")
public interface EurekaFeignServerApi {


    @GetMapping("/test1")
    ResponseEntity<JSONObject> test1();

    @GetMapping("/test2")
    ResponseEntity<String> test2();

    @GetMapping("/test3")
    ResponseEntity<EurekaFeignServerDTO> test3();

    @GetMapping("/test4")
    JSONObject test4();

    @GetMapping("/test5")
    String test5();

    @GetMapping("/test6")
    EurekaFeignServerDTO test6();

}
