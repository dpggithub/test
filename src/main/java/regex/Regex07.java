package regex;

public class Regex07 {
    public static void main(String[] args) {
        String[] strings =new String[]{"3","好好说话","上看看{"};
        for(String s: strings) {
            System.out.println(regex07(s));
        }
    }

    public static boolean regex07(String str){
        String reg ="^[\\u4E00-\\u9FA5]+$";
        return str.matches(reg);
    }
}
