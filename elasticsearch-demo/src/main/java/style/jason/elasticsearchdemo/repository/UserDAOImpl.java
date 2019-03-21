package style.jason.elasticsearchdemo.repository;

import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;
import style.jason.elasticsearchdemo.domain.modul.User;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${elasticsearch.index.name")
    private String indexName;

    @Value("${elasticsearch.user.type}")
    private String userType;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Override
    public List<User> getAllUsers() {
        SearchQuery getAllQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery()).build();
        return esTemplate.queryForList(getAllQuery, User.class);
    }

    @Override
    public User getUserById(String userId) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(QueryBuilders.matchQuery("userId", userId)).build();
        List<User> users = esTemplate.queryForList(searchQuery, User.class);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User addNewUser(User user) {
        IndexQuery userQuery = new IndexQuery();
        userQuery.setIndexName(indexName);
        userQuery.setType(userType);
        userQuery.setObject(user);
        logger.info("user indexed: {}", esTemplate.index(userQuery));
        esTemplate.refresh(indexName);
        return user;
    }

    @Override
    public Object getAllUserSettings(String username) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("username", username)).build();
        List<User> users = esTemplate.queryForList(searchQuery, User.class);
        if (!users.isEmpty()) {
            System.out.println("setings: " + users.get(0).getUserSetting().toString());
            return users.get(0).getUserSetting();
        }
        return null;
    }

    @Override
    public String getUserSetting(String username, String key) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("username", username)).build();
        List<User> users = esTemplate.queryForList(searchQuery, User.class);
        if (!users.isEmpty()) {
            return users.get(0).getUserSetting().get(key);
        }
        return null;
    }

    @Override
    public String addUserSetting(String username, String key, String value) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("username", username)).build();
        List<User> users = esTemplate.queryForList(searchQuery, User.class);
        if (!users.isEmpty()) {
            User user = users.get(0);
            user.getUserSetting().put(key, value);
            IndexQuery userQuery = new IndexQuery();
            userQuery.setIndexName(indexName);
            userQuery.setType(userType);
            userQuery.setId(user.getUserId());
            userQuery.setObject(user);
            esTemplate.index(userQuery);
            return "setting added";
        }
        return null;
    }
}
