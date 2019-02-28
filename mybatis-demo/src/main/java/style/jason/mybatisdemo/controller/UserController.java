package style.jason.mybatisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import style.jason.mybatisdemo.domain.modul.TUser;
import style.jason.mybatisdemo.services.UserService;


@RestController
@RequestMapping("/mybatis")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public TUser getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/{id}/v2")
    @ResponseBody
    public TUser getUserByIdV2(@PathVariable("id") Integer id) {
        return userService.getUserByIdV2(id);
    }
}
