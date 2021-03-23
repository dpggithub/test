package kafka.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("push_message")
public class PushMessage extends BaseTimeEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 消息
     */
    private String msg;

}
