package style.jason.jacksondemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import style.jason.jacksondemo.domain.modul.User;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public User getUser() {
        User user = new User();
        user.setName("jason");
        user.setAge(18);
        user.setPassword("123456");
        user.setBirthday(new Date());
        user.setDesc("test");
        return user;
    }
}
