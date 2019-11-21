package ink.organics.mp.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    @TableId(type = IdType.UUID)
    private String id;
    private String name;
    private Integer age;
    private String email;
}
