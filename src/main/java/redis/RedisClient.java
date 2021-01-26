package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Component
@Repository
public class RedisClient {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /*
     * @ClassName RedisClient
     * @Desc    设置缓存（没有时间限制）
     * @Version 1.0
     */
    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    /*
     * @ClassName RedisClient
     * @Desc 设置缓存（有时间限制，单位为 秒）
     * @Version 1.0
     */
    public void set(String key, Object value,long timeout){
        redisTemplate.opsForValue().set(key, value,timeout, TimeUnit.SECONDS);
    }

    /*
     * @ClassName RedisClient
     * @Desc 删除缓存，并返回是否删除成功
     * @Version 1.0
     */
    public boolean delete(String key){
        redisTemplate.delete(key);
        // 如果还存在这个 key 就证明删除失败
        if(redisTemplate.hasKey(key)){
            return false;
            // 不存在就证明删除成功
        }else{
            return true;
        }
    }

    /*
     * @ClassName RedisClient
     * @Desc 取出缓存
     * @Version 1.0
     */
    public Object get(String key){
        redisTemplate.getExpire(key);
        return redisTemplate.opsForValue().get(key);
    }

    /*
     * @ClassName RedisClient
     * @Desc 获取失效时间（-2：失效 / -1：没有时间限制）
     * @Version 1.0
     */
    public long getExpire(String key){
        // 判断是否存在
        if(redisTemplate.hasKey(key)){
            return redisTemplate.getExpire(key);
        }else{
            return Long.parseLong(-2+"");
        }
    }

}
