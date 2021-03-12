package exception;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
           // e.getSuppressed();
            e.printStackTrace();
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            e.printStackTrace();
           // System.out.println(Arrays.toString(e.getSuppressed()));
            throw e;
        }
    }
}
