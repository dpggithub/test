import org.apache.commons.lang3.RandomStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class UnitTest01 {
    public static void main(String[] args) throws ParseException {
        UnitTest01.Calculator uc=new UnitTest01.Calculator();
              uc.add(5).inc(3).add(5).inc(2).print();
        UnitTest01.Calculator uc1=new UnitTest01.Calculator();
              uc1.inc(5).print();

        String str="jieshuojian,jieshuozhe";
        String[] name=str.split(",");
        System.out.println(Arrays.toString(name));
        String t = RandomStringUtils.randomAlphanumeric(16);
        System.out.println(t);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    static class Calculator {
        private int i;

        public Calculator add(int j) {
            this.i += j;
            return this;
        }

        public Calculator inc(int k) {
            this.i -= k;
            return this;
        }

        public void print() {
            System.out.println(this.i);
        }
    }
}
