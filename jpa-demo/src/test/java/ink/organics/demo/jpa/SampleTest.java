package ink.organics.demo.jpa;

import ink.organics.demo.jpa.model.repository.UserRepository;
import ink.organics.demo.jpa.model.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void rollbackTest1() {
        System.out.println(("----- rollbackTest1 method test ------"));
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            userService.service1(true);
        });
        assertThat(userRepository.findAll().size()).isEqualTo(5);
    }

    @Test
    public void rollbackTest2() {
        System.out.println(("----- rollbackTest2 method test ------"));
        assertThat(userService.service1(false)).isTrue();
        assertThat(userRepository.findAll().size()).isEqualTo(10);
    }
}
