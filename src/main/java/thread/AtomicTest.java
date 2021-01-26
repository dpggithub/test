package thread;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest {
    public static void main(String[] args) {
        IdGenerator idGenerator=new IdGenerator();
        for(int i=0;i<=5;i++) {
            System.out.println(idGenerator.getNextId());
        }
    }
}

class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}