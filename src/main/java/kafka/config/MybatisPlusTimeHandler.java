package kafka.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author 260477
 */
@Component
public class MybatisPlusTimeHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 填充创建时间和更新时间
        long currentTimestamp = System.currentTimeMillis();
        this.setInsertFieldValByName("createTime", currentTimestamp, metaObject);
        this.setInsertFieldValByName("updateTime", currentTimestamp, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 填充更新时间
        this.setUpdateFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
    }

}
