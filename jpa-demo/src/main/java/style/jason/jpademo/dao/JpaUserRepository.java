package style.jason.jpademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import style.jason.jpademo.entity.User;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User, Long> {

    // From user的user指的是实体类中定义的实体类名称
    @Query("from user where user_name like concat('%', ?1, '%')")
    public List<User> findByUserNameLike(String userName);
    @Query("from user where user_name like concat('%', ?1, '%') and note like concat('', ?2, '%')")
    public List<User> findByUserNameLikeOrNoteLike(String userName, String note);
}
