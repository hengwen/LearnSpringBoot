package style.jason.jpademo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import style.jason.jpademo2.domain.dto.ResultResponse;
import style.jason.jpademo2.domain.dto.exception.ResultCode;
import style.jason.jpademo2.domain.modul.User;
import style.jason.jpademo2.repository.UserJpaRepository;
import style.jason.jpademo2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserJpaRepository userJpaRepository;

    @GetMapping
    public ResultResponse index() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return ResultResponse.createSuccessResponse(users);
    }

    /**
     * 排序
     * @param field
     * @param direction
     * @return
     */
    @GetMapping("/sort/{field}/{direction}")
    public ResultResponse findAllBySort(@PathVariable("field") String field, @PathVariable("direction") String direction) {
        // properties参数可变长字符串数组
        Sort.Direction di = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        String[] fields = {field};
        Sort sort = new Sort(di, fields);
        return ResultResponse.createSuccessResponse(userJpaRepository.findAll(sort));
    }

    /**
     * 排序分页
     *
     * @param size
     * @param index
     * @return
     */
    @GetMapping("user/page")
    public ResultResponse getAllUserByPage(@RequestParam("size") Integer size, @RequestParam("index") Integer index) {
        String[] fields = {"age"};
        return ResultResponse.createSuccessResponse(userJpaRepository.findAll(PageRequest.of(index, size, new Sort(Sort.Direction.ASC, fields))));
    }

    /**
     * 排序分页2
     * @param size
     * @param index
     * @return
     */
    @GetMapping("user/page2")
    public ResultResponse getAllUserByPage2(@RequestParam("size") Integer size, @RequestParam("index") Integer index) {
        return ResultResponse.createSuccessResponse(userJpaRepository.findByOrderByAgeAsc(PageRequest.of(index, size)));
    }

    /**
     * 排序分页3:自定义sql查询
     * @param size
     * @param index
     * @return
     */
    @GetMapping("user/page3")
    public ResultResponse getAllUserByPage3(@RequestParam("size") Integer size, @RequestParam("index") Integer index) {
        return ResultResponse.createSuccessResponse(userJpaRepository.findInOrders(PageRequest.of(index, size)));
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
        if (!userRepository.existsById(id)) {
            return ResultResponse.createErrorResponse(ResultCode.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
        return ResultResponse.createSuccessResponse(null);
    }

    @PutMapping("/{id}")
    public ResultResponse edit(@RequestBody User updateUser, @PathVariable("id") Long id) {
        if (!userRepository.existsById(id)) {
            return ResultResponse.createErrorResponse(ResultCode.USER_NOT_FOUND);
        }
        userRepository.save(updateUser);
        return ResultResponse.createSuccessResponse(updateUser);
    }

    @PostMapping
    public ResultResponse store(@RequestBody User user) {
        userRepository.save(user);
        return ResultResponse.createSuccessResponse(null);
    }
}
