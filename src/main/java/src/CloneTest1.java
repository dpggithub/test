package src;

public class CloneTest1 implements Cloneable {
    private String clone1;

    public String getClone1() {
        return clone1;
    }

    public void setClone1(String clone1) {
        this.clone1 = clone1;
    }

    @Override
    public String toString() {
        return "CloneTest1{" +
                "clone1='" + clone1 + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
