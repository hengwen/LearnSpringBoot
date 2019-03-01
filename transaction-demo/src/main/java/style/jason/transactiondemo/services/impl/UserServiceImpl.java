package style.jason.transactiondemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import style.jason.transactiondemo.domain.mapper.TUserMapper;
import style.jason.transactiondemo.domain.modul.TUser;
import style.jason.transactiondemo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public TUser getUserById(Integer id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public int insertUser(TUser tUser) {
        return tUserMapper.insertSelective(tUser);
    }
}
