package regex;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex06 {
    private final List<String> urlPattern = new ArrayList<String>() {
        {
            add("/favicon.ico,/img/*,/js/*,/css/*");
        };
    };

    public static void main(String[] args) {
        String url1 = "/js/jls";
        System.out.println(ifPattern(2,url1));
        System.out.println(ifPattern(1,url1));
    }

    public static boolean ifPattern(Integer i, String str) {
        String[] urls = new Regex06().urlPattern.get(0).split(",");
        String s = new Regex06().urlPattern.get(0);
        StringJoiner sj =new StringJoiner(",", s+",","");
        sj.add("/xx/*");
        System.out.println(sj.toString());
        //urls.
        switch (i) {
            case 1:
                for (String url : urls) {
                Pattern pattern = Pattern.compile("^" + "[^" + url + "]" + "$");
                Matcher m = pattern.matcher(str);
                    if (m.find()) {
                        return true;
                    }
                }
                return false;
            case 2:
                for (String url : urls) {
                    Pattern pattern = Pattern.compile("^" + url);
                    Matcher m = pattern.matcher(str);
                    if (m.find()) {
                        return true;
                    }
                }
                return false;
            default:
                break;
        }
        return false;
    }


}
