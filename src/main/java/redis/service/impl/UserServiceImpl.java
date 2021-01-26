package redis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.RedisClient;
import redis.dao.UserMapper;
import redis.model.User;
import redis.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisClient redisClient;

    @Override
    public boolean saveUser(User user) {
        if (user != null) {
            return save(user);
        }
        return false;
    }

    @Override
    public User selectOne(Long id) {
        User user1 = (User) redisClient.get("userid");
        if (user1 == null) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.select().eq("id", id);
            User user = userMapper.selectOne(wrapper);
            redisClient.set("userid", user, 60 * 60L);
            if (user != null) {
                return user;
            }
        } else if (!user1.getId().equals(id)) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.select().eq("id", id);
            User user = userMapper.selectOne(wrapper);
            redisClient.set("userid", user, 60 * 60L);
            if (user != null) {
                return user;
            }
        }

        if (user1 != null && user1.getId().equals(id)) {
                return user1;
            }else {
                return null;
            }
    }
}
