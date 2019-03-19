package style.jason.jpademo2.repository;

import org.springframework.data.repository.CrudRepository;
import style.jason.jpademo2.domain.modul.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
