package style.jason.mybatisdemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import style.jason.mybatisdemo.domain.mapper.UserMapper;
import style.jason.mybatisdemo.domain.modul.TUser;
import style.jason.mybatisdemo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public TUser getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public TUser getUserByIdV2(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
