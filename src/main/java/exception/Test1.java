package exception;

public class Test1 {
    public static void main(String[] args) {
                try {
                    process1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            static void process1() {
                try {
                    process2();
                } catch (NullPointerException e) {
                    throw new IllegalArgumentException("不能输入非法参数",e);
                }
            }

            static void process2() {
                throw new NullPointerException("空指针异常");
            }
        }

