package designPattern;

/**
 * 桥接模式
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 */
public class BridgeAdapter {

    abstract static class Car{
        protected Engine engine;

        public Car(Engine engine){
            this.engine=engine;
        }

        public abstract void drive();
    }

    interface Engine {
        void start();
    }

    abstract static class RefinedCar extends Car{
        public RefinedCar(Engine engine) {
            super(engine);
        }

        public void drive() {
            this.engine.start();
            System.out.println("Drive " + getBrand() + " car...");
        }

        public abstract String getBrand();
    }

    static class BossCar extends RefinedCar{
        public BossCar(Engine engine) {
            super(engine);
        }

        public String getBrand() {
            return "Boss";
        }
    }

   static class HybridEngine implements Engine {
        public void start() {
            System.out.println("Start Hybrid Engine...");
        }
    }

    public static void main(String[] args) {
        RefinedCar car =new BossCar(new HybridEngine());
        car.drive();
    }
}
