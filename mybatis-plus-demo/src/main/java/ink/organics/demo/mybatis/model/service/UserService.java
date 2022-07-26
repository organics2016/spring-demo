package ink.organics.demo.mybatis.model.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ink.organics.demo.mybatis.model.entity.User;

import java.util.Collection;


public interface UserService extends IService<User> {

    boolean saveBatch(Collection<User> entityList, boolean rollback);
}
