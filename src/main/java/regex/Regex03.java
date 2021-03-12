package regex;

public class Regex03 {
    public static void main(String[] args) {
        String str1 ="https://kuxiaoju-custom.kulchao.com/gree/#/CloudShop/show/gree/bd5519d003fefcf81f6fee9735eab135?clubId=9999";
        System.out.println(regex03(str1));
    }

    public static boolean regex03(String str){
        String reg = "^.*(http|https|fps)\\:\\/\\/\\w.*$";
        return str.matches(reg);
    }
}
