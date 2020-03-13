package ink.organics.demo.eureka.feign.client.api;


import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("EurekaFeignServer")
@RequestMapping("/feign/server")
public interface EurekaFeignServer {


    @GetMapping("/test1")
    ResponseEntity<JSONObject> test1();
}
