package regex;

public class Regex07 {
    public static void main(String[] args) {
        String[] strings =new String[]{"56-2D-C9-75","F4911E698141","EtwfTFEFFr{"};
        for(String s: strings) {
            System.out.println(regex07(s));
        }
    }

    public static boolean regex07(String str){
        String reg ="^[-a-zA-Z0-9]{1,12}$";
        return str.matches(reg);
    }
}
