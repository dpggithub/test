import java.util.Arrays;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        String urlStr ="https://dream-cdn.leayun.cn/public/image/2020-12-17/4c6a501799120371fd2d0964a4d12988.jpg" +
                ", https://dream-cdn.leayun.cn/public/image/2020-12-17/c79229c220e75cdddfc3b7a70b29361c.jpg";
        List<String> urlList = Arrays.asList(urlStr.split(","));
        String url0 =urlList.get(0);
        System.out.println(Arrays.toString(urlList.toArray()));
        System.out.println(url0);
    }
}
