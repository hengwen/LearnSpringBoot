package style.jason.elasticsearchdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import style.jason.elasticsearchdemo.domain.dto.ResultResponse;
import style.jason.elasticsearchdemo.domain.dto.exception.ResultCode;
import style.jason.elasticsearchdemo.domain.modul.User;
import style.jason.elasticsearchdemo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 使用Elasticsearch Repository
 */
@RestController
@RequestMapping("/repo")
public class UserRepositoryController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResultResponse getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return ResultResponse.createSuccessResponse(users);
    }

    @GetMapping("/{userId}")
    public ResultResponse getUser(@PathVariable("userId") Integer userId) {
        logger.info("Geting user with id: {}", userId);
        Optional<User> userOptional = userRepository.findById(String.valueOf(userId));
        if (!userOptional.isPresent()) {
            return ResultResponse.createErrorResponse(ResultCode.USER_NOT_FOUND);
        }
        logger.info("User with id: {} is {}", userId, userOptional.get());
        return ResultResponse.createSuccessResponse(userOptional.get());
    }

    @PostMapping
    public ResultResponse addNewUser(@RequestBody User user) {
        logger.info("Adding new user {}", user);
        userRepository.save(user);
        logger.info("Added user is {}", user);
        return ResultResponse.createSuccessResponse(user);
    }

    @GetMapping("/settings/{userId}")
    public ResultResponse getAllUserSettings(@PathVariable("userId") Integer userId) {
        Optional<User> userOptional = userRepository.findById(String.valueOf(userId));
        if (!userOptional.isPresent()) {
            return ResultResponse.createErrorResponse(ResultCode.USER_NOT_FOUND);
        }
        return ResultResponse.createSuccessResponse(userOptional.get().getUserSetting());
    }

    @GetMapping("/settings/{userId}/{key}")
    public ResultResponse getUserSetting(@PathVariable("userId") Integer userId, @PathVariable("key") String key) {
        Optional<User> userOptional = userRepository.findById(String.valueOf(userId));
        if (!userOptional.isPresent()) {
            return ResultResponse.createErrorResponse(ResultCode.USER_NOT_FOUND);
        }
        return ResultResponse.createSuccessResponse(userOptional.get().getUserSetting().get(key));
    }

    @GetMapping("/settings/{userId}/{key}/{value}")
    public ResultResponse addUserSetting(
            @PathVariable("userId") Integer userId,
            @PathVariable("key") String key,
            @PathVariable("value") String value
    ) {
        Optional<User> userOptional = userRepository.findById(String.valueOf(userId));
        if (!userOptional.isPresent()) {
            return ResultResponse.createErrorResponse(ResultCode.USER_NOT_FOUND);
        }
        User user = userOptional.get();
        user.getUserSetting().put(key, value);
        userRepository.save(user);
        return ResultResponse.createSuccessResponse(user);
    }
}
