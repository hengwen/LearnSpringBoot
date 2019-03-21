package style.jason.elasticsearchdemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import style.jason.elasticsearchdemo.domain.dto.ResultResponse;
import style.jason.elasticsearchdemo.domain.modul.User;
import style.jason.elasticsearchdemo.repository.UserDAO;

/**
 * 使用ElasticsearchTemplate
 */
@RestController
@RequestMapping("user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDAO userDAO;

    @GetMapping("/all")
    public ResultResponse getAllUsers() {
        return ResultResponse.createSuccessResponse(userDAO.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResultResponse getUser(@PathVariable("userId") String userId) {
        return ResultResponse.createSuccessResponse(userDAO.getUserById(userId));
    }

    @PostMapping
    public ResultResponse addNewUser(@RequestBody User user) {
        userDAO.addNewUser(user);
        return ResultResponse.createSuccessResponse(user);
    }

    @GetMapping("/setting/{username}")
    public ResultResponse getAllUserSetting(@PathVariable("username") String username) {
        return ResultResponse.createSuccessResponse(userDAO.getAllUserSettings(username));
    }

    @GetMapping("/setting/{username}/{key}")
    public ResultResponse getUserSetting(@PathVariable("username") String username, @PathVariable("key") String key) {
        return ResultResponse.createSuccessResponse(userDAO.getUserSetting(username, key));
    }

    @GetMapping("/setting/{username}/{key}/{value}")
    public ResultResponse addUserSetting(
            @PathVariable("username") String username,
            @PathVariable("key") String key,
            @PathVariable("value") String value
    ) {
        return ResultResponse.createSuccessResponse(userDAO.addUserSetting(username, key, value));
    }
}
