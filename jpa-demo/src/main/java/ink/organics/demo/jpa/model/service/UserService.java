package ink.organics.demo.jpa.model.service;


import ink.organics.demo.jpa.model.entity.User;
import ink.organics.demo.jpa.model.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean service1(boolean rollback) {

        List<User> users = userRepository.findAll().stream().map(user -> {
            User user1 = new User();
            BeanUtils.copyProperties(user, user1);
            return user1;
        }).peek(user -> user.setId(null)).collect(Collectors.toList());

        userRepository.saveAllAndFlush(users);

        if (rollback) {
            throw new RuntimeException("rollback");
        }

        return true;
    }
}
