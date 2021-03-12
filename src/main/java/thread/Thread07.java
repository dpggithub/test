package thread;

import java.util.concurrent.locks.StampedLock;

public class Thread07 {
    public static void main(String[] args) {
        Thread07.Point point = new Point(3, 4);
            Thread t = new Thread() {
                @Override
                public void run() {
                    point.move(6.0, 8.0);
                }
            };
            t.start();

            Thread ts = new Thread(() -> {
                System.out.println(point.distanceFromOrigin());
            });
            ts.start();

    }

    static class Point {
        private final StampedLock stampedLock = new StampedLock();

        private double x, y;

        public Point(double x, double y){
            this.x =x;
            this.y =y;
        }

        public void move(double deltaX, double deltaY) {
            long wlock = stampedLock.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                stampedLock.unlockWrite(wlock);
            }
        }

        public double distanceFromOrigin() {
            long rlock = stampedLock.tryOptimisticRead();
            double currentX = x;
            double currentY = y;
            if (!stampedLock.validate(rlock)) {
                rlock = stampedLock.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    stampedLock.unlockRead(rlock);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }
    }
}
