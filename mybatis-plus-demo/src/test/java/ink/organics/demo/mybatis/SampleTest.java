package ink.organics.demo.mybatis;

import ink.organics.demo.mybatis.model.entity.User;
import ink.organics.demo.mybatis.model.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
public class SampleTest {


    @Autowired
    private UserService userService;

    @Test
    public void rollbackTest1() {
        System.out.println(("----- rollbackTest1 method test ------"));
        List<User> users = userService.list();
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            userService.saveBatch(users, true);
        });
        assertThat(userService.list().size()).isEqualTo(5);
    }

    @Test
    public void rollbackTest2() {
        System.out.println(("----- rollbackTest2 method test ------"));
        List<User> users = userService.list();
        assertThat(userService.saveBatch(users, false)).isTrue();
        assertThat(userService.list().size()).isEqualTo(10);
    }
}
