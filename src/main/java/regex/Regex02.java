package regex;

public class Regex02 {
    public static void main(String[] args) {
        String[] strings =new String[]{"java9","java10","java#"};
        for(String s: strings) {
            System.out.println(regex02(s));
        }
    }

    public static boolean regex02(String str){
        String reg ="^java\\d{1,2}$";
        return str.matches(reg);
    }

}
