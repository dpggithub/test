package regex;

import com.lyentech.bdc.exception.BusinessException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex05 {
    public static void main(String[] args) {
        String str="00:26:05";
        String[] str1= new String[]{"990923199407033931"};
        System.out.println(regex05(str1));
        regex05(str);
    }

    public static void regex05(String str){
        Pattern p = Pattern.compile("([0-1]?\\d|2[0-3])\\:([0-5]?\\d)\\:([0-5]?\\d)");
        Matcher m= p.matcher(str);
        if(m.matches()){
            String hour = m.group(1);
            String minute =m.group(2);
            String second =m.group(3);
            System.out.println(hour);
            System.out.println(minute);
            System.out.println(second);
        }else {
            throw new BusinessException("无法匹配的字符串");
        }
    }

    public static boolean regex05(String[] str){
        for(String s: str){
            Pattern p =Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
            if(p.matcher(s).matches()){
                return true;
            }
        }
        return false;
    }
}
