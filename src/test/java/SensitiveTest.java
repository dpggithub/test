import com.lyentech.bdc.sensitive.annotation.BdcSensitive;
import com.lyentech.bdc.sensitive.annotation.SensitiveTypes;
import com.lyentech.bdc.sensitive.maskers.AddressMasker;
import com.lyentech.bdc.util.SensitiveUtil;

public class SensitiveTest {
    @BdcSensitive(type = SensitiveTypes.ADDRESS, maskclass = AddressMasker.class,masked = true, maskchar = "*")
    String address;
    SensitiveTest(String address){
        this.address=address;
    }

    @Override
    public String toString() {
        return "SensitiveTest{" +
                "address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        SensitiveTest sensitiveTest=new SensitiveTest("广东省珠海市香洲区");
        SensitiveUtil.maskObject(sensitiveTest);
        System.out.println(sensitiveTest.toString());
    }
}
