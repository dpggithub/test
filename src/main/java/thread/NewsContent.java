package thread;

import java.util.List;

public class NewsContent {
    private List<FinallyDemo> finallyDemoList;

    public List<FinallyDemo> getFinallyDemoList() {
        return finallyDemoList;
    }

    public void setFinallyDemoList(List<FinallyDemo> finallyDemoList) {
        this.finallyDemoList = finallyDemoList;
    }

    @Override
    public String toString() {
        return "NewsContent{" +
                "finallyDemoList=" + finallyDemoList +
                '}';
    }
}
