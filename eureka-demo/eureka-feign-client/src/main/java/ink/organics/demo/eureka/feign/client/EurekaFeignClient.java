package ink.organics.demo.eureka.feign.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EurekaFeignClient {


    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClient.class, args);
    }
}
