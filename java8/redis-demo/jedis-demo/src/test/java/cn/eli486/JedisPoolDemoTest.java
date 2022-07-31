package cn.eli486;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.Duration;


/**
 * @author eli486
 * @date 2022/7/31 16:07
 */
public class JedisPoolDemoTest {

    private Jedis jedis;
    private static final JedisPool pool;

    static {
        pool = new JedisPool("192.168.227.129", 6379);
        pool.setMaxTotal(8);
        pool.setMaxIdle(8);
        pool.setMinIdle(8);
        pool.setMaxWait(Duration.ofSeconds(3));
    }

    @BeforeEach
    void init(){
        jedis = pool.getResource();

    }

    @Test
    void testConnection(){
        System.out.println(jedis.ping());
    }

    @Test
    void test(){
        //common command key
        //keys: get all keys
        System.out.println(jedis.keys("*"));

        //delete key
        System.out.println(jedis.del("user:1"));
        //1.string
        //get one key's value
        String name = jedis.get("name");
        System.out.println(name);

        //set one key
        jedis.set("name","eli");

        //2.list

        jedis.lpush("k1","v1");

        //3.hash

        //4.set

        //5.hashset


    }

    @AfterEach
    void close(){
        jedis.close();
    }


}
