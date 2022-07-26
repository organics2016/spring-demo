package ink.organics.demo.mybatis;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = "ink.organics.demo.mybatis.model.mapper")
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    // MybatisPlus Support @Version https://baomidou.com/pages/0d93c0/#_2-%E5%9C%A8%E5%AE%9E%E4%BD%93%E7%B1%BB%E7%9A%84%E5%AD%97%E6%AE%B5%E4%B8%8A%E5%8A%A0%E4%B8%8A-version%E6%B3%A8%E8%A7%A3
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }
}
