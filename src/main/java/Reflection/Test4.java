package Reflection;

public class Test4 {
    public static void main(String[] args) {
        Test2.Pilot p=new Test2.Pilot();
        Class c1=p.getClass();
        System.out.println(c1);
        Class c2=c1.getSuperclass();
        System.out.println(c2);
    }
}
