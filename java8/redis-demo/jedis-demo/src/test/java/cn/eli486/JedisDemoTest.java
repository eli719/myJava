package cn.eli486;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;


/**
 * @author eli486
 * @date 2022/7/31 16:07
 */
public class JedisDemoTest {

    private Jedis jedis;

    @BeforeEach
    void init(){
        //1.create a redis connection
        jedis = new Jedis("192.168.227.129", 6379);
        //auth
        jedis.auth("");
        //select db
        jedis.select(0);

    }

    @Test
    void testConnection(){
        System.out.println(jedis.ping());
    }

    @AfterEach
    void close(){
        jedis.close();
    }


}
