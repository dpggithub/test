package src.zhengZe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhengZeTest1 {
    public static void main(String[] args) {
        String re = "(0\\d{2,3})-(\\d{7,8})";
        Pattern p=Pattern.compile(re);
        String[] strings=new String[]{"010-12345678", "020-9999999", "0755-7654321"};
        for(String string : strings){
            Matcher matcher= p.matcher(string);
            if(matcher.matches()){
                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
            }
        }
    }
}
