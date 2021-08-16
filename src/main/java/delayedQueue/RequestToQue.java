package delayedQueue;

import javax.servlet.http.HttpServletRequest;

public class RequestToQue {

    private String userId;

    private HttpServletRequest request;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
