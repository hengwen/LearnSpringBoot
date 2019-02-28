package style.jason.jpademo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import style.jason.jpademo.dao.JpaUserRepository;
import style.jason.jpademo.entity.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/user")
public class JpaUserController {
    @Autowired
    private JpaUserRepository jpaUserRepository;

    @GetMapping("/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable("userId") Long userId) {
        System.out.println(userId);
        Optional<User> byId = jpaUserRepository.findById(userId);

        if (!byId.isPresent()) {
            return new User();
        }
        User user = byId.get();

        return user;
    }

    @GetMapping("/findByUserNameLike")
    @ResponseBody
    public List<User> findByUserNameLike(@RequestParam("userName") String userName) {
        return jpaUserRepository.findByUserNameLike(userName);
    }

    @GetMapping("/findByUserNameLikeOrNoteLike")
    @ResponseBody
    public List<User> findByUserNameLikeOrNoteLike(@RequestParam("userName") String userName, @RequestParam("note") String note) {
        return jpaUserRepository.findByUserNameLikeOrNoteLike(userName, note);
    }
}
