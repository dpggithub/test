package src;

import com.lyentech.bdc.exception.BusinessException;

public class DataTypeTest {
    public static void main(String[] args) {
        Object ob= true;
        if(new DataTypeTest().dataTypeVerify(ob)) {
            System.out.println(new DataTypeTest().dataTypeVerify(ob));
        }else {
            throw new BusinessException("请输入四位以内整型");
        }
    }

    public boolean dataTypeVerify(Object o){
        return o instanceof Integer;
    }
}
