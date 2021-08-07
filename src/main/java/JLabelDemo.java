import javax.swing.*;
import java.awt.*;

public class JLabelDemo {
    public static void main(String[] agrs) {
//        JFrame frame=new JFrame("Java标签组件示例");    //创建Frame窗口
//        JPanel jp=new JPanel();    //创建面板
//
//        JLabel label1=new JLabel("普通标签");    //创建标签
//        JLabel label2=new JLabel();
//
//        label2.setText("调用setText()方法");
//
//        ImageIcon img=new ImageIcon();    //创建一个图标
//
//        //创建既含有文本又含有图标的JLabel对象
//        JLabel label3=new JLabel("开始理财",img,SwingConstants.LEFT);
//
////        jp.add(label1);    //添加标签到面板
////        jp.add(label2);
//        jp.add(label3);
//
//        frame.add(jp);
//
//        frame.setBounds(0,0,686,1058);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JFrame frame = new JFrame("JLable Test") ;
        JLabel lab = new JLabel("我是一个标签",JLabel.CENTER) ;   // 实例化标签对象
        frame.add(lab) ;    // 将组件件入到面板之中
        frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色

        Dimension dim = new Dimension() ;
        dim.setSize(400,300) ;              //窗体的大小
        frame.setSize(dim) ;                //设置窗体大小
        Point point = new Point(600,400) ;  // 设置坐标
        frame.setLocation(point) ;          //设置窗体坐标
        frame.setVisible(true) ;            //设置窗体可见
    }
}
