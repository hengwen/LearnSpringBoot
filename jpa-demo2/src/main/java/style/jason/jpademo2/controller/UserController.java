package style.jason.jpademo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import style.jason.jpademo2.domain.dto.ResultResponse;
import style.jason.jpademo2.domain.dto.exception.ResultCode;
import style.jason.jpademo2.domain.dto.exception.TossException;
import style.jason.jpademo2.domain.modul.User;
import style.jason.jpademo2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResultResponse index() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return ResultResponse.createSuccessResponse(users);
    }

    @GetMapping("/{id}")
    public ResultResponse detail(@PathVariable("id") Long id) {
//        User user = userRepository.findById(id).orElseThrow(() -> new TossException(ResultCode.UNKNOWN_ERROR));
//        User user = userRepository.findById(id).orElse(null);
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            return ResultResponse.createErrorResponse(ResultCode.USER_NOT_FOUND);
        }
        return ResultResponse.createSuccessResponse(userOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResultResponse delete(@PathVariable("id") Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            return ResultResponse.createErrorResponse(ResultCode.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
        return ResultResponse.createSuccessResponse(null);
    }

    @PutMapping("/{id}")
    public ResultResponse edit(@RequestBody User updateUser, @PathVariable("id") Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new TossException(ResultCode.UNKNOWN_ERROR));
        user.setUsername(updateUser.getUsername());
        user.setAge(updateUser.getAge());
        userRepository.save(user);
        return ResultResponse.createSuccessResponse(user);
    }

    @PostMapping
    public ResultResponse store(@RequestBody User user) {
        userRepository.save(user);
        return ResultResponse.createSuccessResponse(null);
    }
}
