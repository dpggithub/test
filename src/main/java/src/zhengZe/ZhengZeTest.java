package src.zhengZe;

public class ZhengZeTest {
    public static void main(String[] args) throws Exception {
        String re = "(0\\d{2,3})\\-(\\d{7,8})";

        String[] strings=new String[]{"010-12345678", "020-9999999", "0755-7654321"};
        for (String s : strings) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }

        String[] strings1=new String[]{"010 12345678", "A20-9999999", "0755-7654.321"};
        for (String s : strings1) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}
