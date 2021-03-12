public class UnitTest01 {
    public static void main(String[] args) {
        UnitTest01.Calculator uc=new UnitTest01.Calculator();
              uc.add(5).inc(3).add(5).inc(2).print();
        UnitTest01.Calculator uc1=new UnitTest01.Calculator();
              uc1.inc(5).print();

    }

    static class Calculator {
        private int i;

        public Calculator add(int j) {
            this.i += j;
            return this;
        }

        public Calculator inc(int k) {
            this.i -= k;
            return this;
        }

        public void print() {
            System.out.println(this.i);
        }
    }
}
