package style.jason.redisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import style.jason.redisdemo.domain.entity.User;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(RedisDemoApplicationTests.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Serializable> redisCacheTemplate;


	@Test
	public void testRedis() {
		stringRedisTemplate.opsForValue().set("k1", "v1");
		final String k1 = stringRedisTemplate.opsForValue().get("k1");
		log.info("[字符缓存结果] - [{}]", k1);
		String key = "battcn:user:1";
		redisCacheTemplate.opsForValue().set(key, new User(1L, "u1", "pa"));
		final User user = (User) redisCacheTemplate.opsForValue().get(key);
		log.info("[对象缓存结果] - [{}]", user);
	}

}
