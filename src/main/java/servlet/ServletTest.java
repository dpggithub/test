package servlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ServletTest {


    @GetMapping("servlet")
    public void servlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("windows","X86");
        response.setHeader("lang","CN-Chinese");
        Cookie cookie=new Cookie("XXX","no-status");
        cookie.setPath("/");
        cookie.setComment("获取cookie!");
        response.addCookie(cookie);
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
