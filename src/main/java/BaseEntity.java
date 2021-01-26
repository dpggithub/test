import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 基类中时间写法如下，fill属性指定填充规则，业务类继承即可
 */
public class BaseEntity {
    @TableField(fill = FieldFill.INSERT)
    private Long createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;
}

/**
 * MetaObjectHandler的实现类，实现数据库create_time和update_time字段的统一维护
 *
 * @author 260205
 */
@Component
class MybatisPlusTimeFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 填充创建时间和更新时间
        long currentTimestamp = System.currentTimeMillis();
        this.setFieldValByName("createTime", currentTimestamp, metaObject);
        this.setFieldValByName("updateTime", currentTimestamp, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 填充更新时间
        this.setFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
    }
}
