package src.exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class NegativeException {
     String ex;

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public NegativeException(){}

    public NegativeException(String ex) {
        this.ex = ex;
    }



    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入一个数 ");
            int i = scanner.nextInt();
        if(i<0){
            throw new IllegalArgumentException("参数不能为负值！");
        }else {
            System.out.println(i);
        }


        Class<NegativeException> cls=NegativeException.class;
        Field field= cls.getDeclaredField("ex");
        System.out.println(field.getType());
        System.out.println(field.getName());
        // public(1) private(2) protected(4)
        System.out.println(field.getModifiers());
        System.out.println(field.toString());

        Package aPackage=cls.getPackage();
        System.out.println(aPackage);

        NegativeException N=new NegativeException();
        NegativeException N1=new NegativeException("你好！");
        Method method=N.getClass().getMethod("setEx", String.class);
        Method method1=N1.getClass().getMethod("getEx");
        method.invoke(N,"抛异常！");
        System.out.println(method1.invoke(N1));
        System.out.println("ex is "+N.ex);



         //String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class,int.class);
        // 在s对象上调用该方法并获取结果，左闭右开[m,n):
        String r = (String) m.invoke(s, 0,4);
        // 打印调用结果:
        System.out.println(r);

        //Class<Ne> ee=Ne.class;
        //Class<Ne> ee= (Class<Ne>) Class.forName("src.exception.NegativeException$Ne");
        NegativeException ne=new Ne();
        Class<Ne> ee= (Class<Ne>) ne.getClass();
        Class<Ne> e= (Class<Ne>) ee.getSuperclass();
        System.out.println("e: "+e);

        Constructor constructor=ee.getConstructor(null);
        Constructor constructor1=ee.getConstructor(int.class,String.class);
        Ne ne1=(Ne) constructor1.newInstance(1,"2");
        System.out.println("constructor1 :"+constructor1.toString());
        System.out.println(ne1.getEx()+" "+ne1.getX());



    }

    static class Ne extends NegativeException{
        int x;

        public Ne(){}

        public Ne(int x,String ex){
            super(ex);
            this.x=x;
        }


        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}
