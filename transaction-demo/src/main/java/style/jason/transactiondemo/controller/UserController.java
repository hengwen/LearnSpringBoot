package style.jason.transactiondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import style.jason.transactiondemo.domain.modul.TUser;
import style.jason.transactiondemo.services.UserService;

// TODO 测试事务的隔离级别和传播行为以及在同一个类中自调用生成子事务
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public TUser getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/insert")
    public TUser insertUser() {
        TUser tUser = new TUser();
        tUser.setUserName("username");
        tUser.setSex(1);
        tUser.setNote("test");
        userService.insertUser(tUser);
        return tUser;
    }
}
