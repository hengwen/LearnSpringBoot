package style.jason.mybatisdemo.domain.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import style.jason.mybatisdemo.domain.modul.TUser;
import style.jason.mybatisdemo.domain.tk.TKMapper;

@Component
public interface UserMapper extends TKMapper<TUser> {
    public TUser getUserById(@Param("id") Integer id);
}