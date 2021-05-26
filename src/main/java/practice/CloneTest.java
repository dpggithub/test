package practice;

import src.CloneTest1;

import java.util.Date;

/**
 * 深拷贝： 对基本数据类型进行值传递，对引用数据类型，创建一个新的，对其进行赋值。（两个指针指向不同的内存单元）
 * 浅拷贝：对基本数据类型进行值传递，对引用数据类型进行引用(类似C 中的指针，等于两个指针指向同一个内存单元)
 */
public class CloneTest implements Cloneable {
    private String clone;

    private Date time;

    private CloneTest1 cloneTest1;

    public String getClone() {
        return clone;
    }

    public void setClone(String clone) {
        this.clone = clone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public CloneTest1 getCloneTest1() {
        return cloneTest1;
    }

    public void setCloneTest1(CloneTest1 cloneTest1) {
        this.cloneTest1 = cloneTest1;
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "clone='" + clone + '\'' +
                ", time=" + time +
                ", cloneTest1=" + cloneTest1 +
                '}';
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        // return super.clone(); 浅拷贝

        // 深拷贝
        CloneTest cloneTest =(CloneTest) super.clone();
        cloneTest.setCloneTest1((CloneTest1) cloneTest1.clone());
        cloneTest.setTime((Date) this.time.clone());
        return cloneTest;
    }

    public static void main(String[] args) {
        CloneTest cloneTest = new CloneTest();
        cloneTest.setClone("克隆");
        cloneTest.setTime(new Date());

        CloneTest1 cloneTest1 = new CloneTest1();
        cloneTest1.setClone1("克隆1");
        cloneTest.setCloneTest1(cloneTest1);
        System.out.println("原对象:" + cloneTest + "，精确时间为:" + cloneTest.getTime().getTime());

        try {
            CloneTest clone = (CloneTest) cloneTest.clone();
            System.out.println("克隆后的对象是否与原对象是在内存中是同一个:" + (clone == cloneTest));
            System.out.println("克隆后的对象" + clone + "，精确时间为:" + clone.getTime().getTime());
            System.out.println("克隆后的房屋的窗户是否和原对象窗户在内存中为同一个" + (clone.getCloneTest1() == cloneTest.getCloneTest1()));
            System.out.println("克隆后的房屋的窗户是否和原对象生产日期在内存中为同一个" + (clone.getTime() == cloneTest.getTime()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}

