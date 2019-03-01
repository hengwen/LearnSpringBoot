package style.jason.transactiondemo.domain.modul;

import lombok.Data;

import javax.persistence.Id;

@Data
public class TUser {

    @Id
    private Integer id;

    private String userName;

    private Integer sex;

    private String note;
}