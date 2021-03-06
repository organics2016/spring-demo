package ink.organics.demo.mybatis;

import ink.organics.demo.mybatis.model.entity.User;
import ink.organics.demo.mybatis.model.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {


    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> users = userService.list();

        userService.saveBatch(users);
    }

    @Test
    public void test2() {


    }
}
