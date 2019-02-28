package style.jason.jacksondemo.domain.modul;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
// null不返回
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String name;

    @JsonIgnore
    private String password;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Date birthday;

    private String desc;

    private String mark;
}
