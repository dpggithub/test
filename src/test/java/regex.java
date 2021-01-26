import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        String str = "dhjs#,.*&$@!~";
        specialCharRegex(str);
        System.out.println(specialCharRegex(str));
        System.out.println(replaceSpace(new StringBuffer("hello world")));

    }

    public static boolean specialCharRegex(String str){
        Pattern p = Pattern.compile("^.*[(\\s)|(+)|(=)|(%)|(/)].*$");
        Matcher m= p.matcher(str);
        return m.matches();
    }

    public static String replaceSpace(StringBuffer str) {
        String str1=str.toString();
        return str1.replace(" ","20%");
    }
}
