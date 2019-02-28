package style.jason.mybatisdemo.services;

import style.jason.mybatisdemo.domain.modul.TUser;

public interface UserService {
    public TUser getUserById(Integer id);

    public TUser getUserByIdV2(Integer id);
}
