package redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import redis.model.User;
import java.util.List;


public interface UserService extends IService<User> {

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    public boolean saveUser(User user);


    /**
     * 查询用户列表
     * @return
     */
    public User selectOne(Long id);
}
