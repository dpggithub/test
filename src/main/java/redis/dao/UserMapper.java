package redis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import redis.model.User;


@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
