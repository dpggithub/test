package kafka.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kafka.model.PushMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@Mapper
public interface PushMessageMapper extends BaseMapper<PushMessage> {
}
