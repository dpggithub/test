package designPattern;

/**
 * 原型模式
 */
public class ProtoType {
    private String sss;

    public ProtoType(String sss) {
        this.sss = sss;
    }

    public ProtoType(){}

    public ProtoType copy(){
        ProtoType protoType =new ProtoType();
        protoType.sss=this.sss;
        return protoType;
    }

    public static void main(String[] args) {
        ProtoType protoType1 =new ProtoType("111");
        ProtoType protoType2 =protoType1.copy();
        System.out.println(protoType2.equals(protoType1));
    }
}
