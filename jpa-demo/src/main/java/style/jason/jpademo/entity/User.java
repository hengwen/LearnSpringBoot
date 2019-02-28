package style.jason.jpademo.entity;

import lombok.Data;
import style.jason.jpademo.converter.SexConverter;
import style.jason.jpademo.enumeration.SexEnum;

import javax.persistence.*;

@Entity(name="user")
@Table(name="t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(name="user_name")
    private String userName = null;
    private String note = null;
    @Convert(converter = SexConverter.class)
    private SexEnum sex = null;
}
