package designPattern;

/**
 * 适配器模式
 * 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 */
public interface AdapterPattern {
    int add(int a);

    interface B{
        public int a = 5;
    }

    class A implements B{

    }

    class Adapter implements AdapterPattern{
        private B b;

        public Adapter(B b){
            this.b=b;
        }

        @Override
        public int add(int a) {
           return b.a+a;
        }
    }

    public static void main(String[] args) {
        B b =new A();
        AdapterPattern adapterPattern =new Adapter(b);
        System.out.println(adapterPattern.add(3));
    }
}