package style.jason.jpademo2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import style.jason.jpademo2.domain.modul.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Page<User> findByOrderByAgeAsc(Pageable pageable);

    // 自定义sql查询
//    @Query(value = "select id,username,age from user order by age asc", nativeQuery = true)  // 原生写法
    @Query(value = "select u.id,u.username,u.age from User u order by u.age asc")   // JPQL写法
    Page<User> findInOrders(Pageable pageable);
}
