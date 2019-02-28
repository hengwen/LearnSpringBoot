package style.jason.mybatisdemo.domain.modul;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;

@Data
//MyBatis别名
@Alias(value = "user")
public class TUser {

    @Id
    private Integer id;

    private String userName;

    private Integer sex;

    private String note;
}