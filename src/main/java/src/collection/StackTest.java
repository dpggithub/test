package src.collection;

import java.util.Scanner;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入一个整数: ");
        int n=in.nextInt();
        String hex = toHex(n);
//        if (hex.equalsIgnoreCase("30D4")) {
//            System.out.println("测试通过");
//        } else {
//            System.out.println("测试失败");
//        }
        String s=String.format("%d"+"转换为十六进制是: "+"%s",n,hex);
        System.out.println(s);
    }

    static String toHex(int n) {
        StringBuilder str =new StringBuilder("Ox");
        Stack<String> stack =new Stack<>();
        // 定义商
        Integer S=0;
        // 定义余数
        int Y=0;
        // 入栈
        do {
            S = n / 16;
            Y = n % 16;
            n = S;
            stack.push(replace(Integer.toString(Y)));
        } while (!S.equals(0));
        // 出栈
        while (!stack.empty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }

    static String replace(String s) {
        String s1=s;
        if (s.equals("10")) {
            s1="A";
        }

        if (s.equals("11")) {
            s1="B";
        }

        if (s.equals("12")) {
            s1="C";
        }

        if (s.equals("13")) {
            s1="D";
        }

        if (s.equals("14")) {
            s1="E";
        }

        if (s.equals("15")) {
            s1="F";
        }
        return s1;
    }
}
