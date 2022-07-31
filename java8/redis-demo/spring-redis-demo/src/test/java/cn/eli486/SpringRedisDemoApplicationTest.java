package cn.eli486;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

/**
 * @author eli486
 * @date 2022/7/31 17:07
 */
@SpringBootTest
public class SpringRedisDemoApplicationTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void init(){
        System.out.println(Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().ping());
    }
}
