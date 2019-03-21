package style.jason.elasticsearchdemo.domain.modul;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document(indexName="es_demo", type = "user")
public class User {
    @Id
    private String userId;
    private String username;
    private Integer age;
//    private Date creationDate = new Date();
    private Map<String, String> userSetting = new HashMap<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
//
//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }

    public Map<String, String> getUserSetting() {
        return userSetting;
    }

    public void setUserSetting(Map<String, String> userSetting) {
        this.userSetting = userSetting;
    }
}
