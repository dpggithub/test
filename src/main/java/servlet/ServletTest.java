package servlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ServletTest {


    @GetMapping("/servlet")
    public void servlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("windows","X86");
        response.setHeader("lang","CN-Chinese");
        Cookie cookie=new Cookie("XXX","no-status");
        cookie.setPath("/");
        cookie.setComment("获取cookie!");
        response.addCookie(cookie);

        HttpSession session =request.getSession();
        // 获取 session 创建时间
        Date createTime = new Date(session.getCreationTime());
        // 获取该网页的最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        //设置日期输出的格式
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String title = "Servlet Session 实例 - 菜鸟教程";
        Integer visitCount = new Integer(0);
        String visitCountKey = new String("visitCount");
        String userIDKey = new String("userID");
        String userID = new String("Runoob");
        if(session.getAttribute(visitCountKey) == null) {
            session.setAttribute(visitCountKey, new Integer(0));
        }


        // 检查网页上是否有新的访问者
        if (session.isNew()){
            title = "Servlet Session 实例 - 菜鸟教程";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer)session.getAttribute(visitCountKey);
            visitCount = visitCount + 1;
            userID = (String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey,  visitCount);

        System.out.println(session.getAttribute(userIDKey).toString());
        System.out.println(session.getAttribute(visitCountKey).toString());
        System.out.println(df.format(createTime));
        System.out.println(df.format(lastAccessTime));

        System.out.println(getCookie(request));
        System.out.println(request.getAttribute("windows"));
        System.out.println(response.getHeader("lang"));
    }

    private String getCookie(HttpServletRequest request){
        String value="";
        Cookie[] cookies=request.getCookies();
        if(cookies!=null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                if (cookie.equals("XXX")) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }
}
