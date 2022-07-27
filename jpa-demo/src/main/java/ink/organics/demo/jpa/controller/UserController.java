package ink.organics.demo.jpa.controller;

import ink.organics.demo.jpa.dto.UserDTO;
import ink.organics.demo.jpa.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/rollback")
    public ResponseEntity<Object> rollback(@Valid @RequestBody UserDTO dto) {
        userService.service1(dto.getRollback());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Object> all() {
        return ResponseEntity.ok(userService.all());
    }

}
