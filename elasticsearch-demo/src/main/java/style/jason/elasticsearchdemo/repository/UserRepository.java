package style.jason.elasticsearchdemo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import style.jason.elasticsearchdemo.domain.modul.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
}
