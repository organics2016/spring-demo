package ink.organics.demo.jpa.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 过滤空属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // setter 失败不抛出异常
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        // 允许出现特殊字符和转义符
//        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        // 允许出现单引号
//        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateUtils.sf));
        timeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateUtils.sf));
        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateUtils.stf));
        timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateUtils.stf));
        timeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateUtils.tf));
        timeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateUtils.tf));

        objectMapper.registerModule(timeModule);

        return objectMapper;
    }

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
//        filter.setIncludeClientInfo(true);
//        filter.setIncludeHeaders(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(1000);
        return filter;
    }

    // Etag
    @Bean
    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }

    // CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // 容许所有跨域
                        .allowedMethods("*") // 允许所有method
                        .allowCredentials(false) // 服务器不要cookie
                        .allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.ETAG); // AUTHORIZATION 用于前端jwt验证，ETAG 用于前端协商缓存
            }
        };
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplateBuilder builder = new RestTemplateBuilder();
//        RestTemplate restTemplate = builder.build();
//        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
//        return restTemplate;
//    }

}
