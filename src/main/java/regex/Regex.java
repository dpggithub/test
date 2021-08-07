package regex;

public class Regex {
    public static void main(String[] args) {
        String[] strings =new String[]{"0784-64231321","80008205216","13420066042","021-5128-0635","02151280635"};
        for(String s: strings) {
            System.out.println(regex(s));
        }
    }

    public static boolean regex(String str){
        String reg ="(^1[3456789]\\d{9}$)|(^\\d{3}-\\d{7,8}|\\d{4}-\\d{7,8}$)|(^\\d{3}-\\d{4}-\\d{4}$)|(^\\d{3}\\d{7,8}|\\d{4}\\d{7,8}$)|(^[\\u4E00-\\u9FA5\\uf900-\\ufa2d·•s]{2,16}$)";
        return str.matches(reg);
    }
}
