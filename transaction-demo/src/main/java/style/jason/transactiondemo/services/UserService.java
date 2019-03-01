package style.jason.transactiondemo.services;

import style.jason.transactiondemo.domain.modul.TUser;

public interface UserService {
    TUser getUserById(Integer id);

    int insertUser(TUser tUser);
}
