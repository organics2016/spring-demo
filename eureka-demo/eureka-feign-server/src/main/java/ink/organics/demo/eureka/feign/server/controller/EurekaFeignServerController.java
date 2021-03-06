package ink.organics.demo.eureka.feign.server.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;


@Controller
@RequestMapping("/feign/server")
public class EurekaFeignServerController {

    @GetMapping("/test1")
    public ResponseEntity test1() {

        JSONObject json = new JSONObject();
        json.put("hhh", UUID.randomUUID().toString());

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/test2")
    public ResponseEntity test2() {
        return this.test1();
    }

    @GetMapping("/test3")
    public ResponseEntity test3() {
        return this.test1();
    }

    @GetMapping("/test4")
    public ResponseEntity test4() {
        return this.test1();
    }

    @GetMapping("/test5")
    public ResponseEntity test5() {
        return this.test1();
    }

    @GetMapping("/test6")
    public ResponseEntity test6() {
        return this.test1();
    }

}
