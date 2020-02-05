package ink.organics.demo.mybatis.model.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import ink.organics.demo.mybatis.model.entity.User;
import ink.organics.demo.mybatis.model.mapper.UserMapper;
import ink.organics.demo.mybatis.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean saveBatch(Collection<User> entityList) {

        List<User> users1 = entityList.stream().peek(user -> user.setId(null)).collect(Collectors.toList());
        List<User> users2 = users1.stream().map(user -> {
            User u = new User();
            BeanUtils.copyProperties(user, u);
            return u;
        }).collect(Collectors.toList());


        boolean sss = saveBatch(users1, 1000);
        saveBatch(users2, 1000);

        if (sss) {
            throw new RuntimeException("zxzzz");
        }
        return sss;
    }
}
