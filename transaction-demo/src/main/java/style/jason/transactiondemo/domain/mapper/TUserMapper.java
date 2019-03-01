package style.jason.transactiondemo.domain.mapper;

import org.springframework.stereotype.Component;
import style.jason.transactiondemo.domain.modul.TUser;
import style.jason.transactiondemo.domain.tk.TKMapper;

@Component
public interface TUserMapper extends TKMapper<TUser> {

}