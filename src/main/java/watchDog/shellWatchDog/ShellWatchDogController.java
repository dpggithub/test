package watchDog.shellWatchDog;

import com.alibaba.fastjson.JSON;
import com.lyentech.bdc.http.response.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ShellWatchDogController {

    @Autowired
    private ShellProperties shellProperties;

    @RequestMapping("/get")
    public ResultEntity getProperties(){
        Map<String,String> propertyMap = new HashMap<>(3);
        propertyMap.put("directory",shellProperties.getDirectory());
        propertyMap.put("startupFileName",shellProperties.getStartupFileName());
        propertyMap.put("restartFileName", shellProperties.getRestartFileName());
        System.out.println(JSON.toJSONString(propertyMap));
        return ResultEntity.success();
    }
}
