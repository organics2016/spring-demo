package ink.organics.demo.jpa.model.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User extends BaseEntity {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
}
