package thread;

import java.util.ArrayList;
import java.util.List;

public class NewsTest {
    public static void main(String[] args) {
        FinallyDemo finallyDemo=new FinallyDemo();
        List<FinallyDemo> finallyDemoList=new ArrayList<>();
        NewsContent newsContent=new NewsContent();
        Item item=new Item();
        List<Item> itemList=new ArrayList<>();
        NewsRoot newsRoot=new NewsRoot();


        finallyDemo.setTitle("HAHAH");
        finallyDemo.setContent_source_url("hdjd");
        finallyDemo.setContent("hdjd");
        finallyDemo.setAuthor("hdjd");
        finallyDemo.setDigest("hdjd");
        finallyDemo.setShow_cover_pic("hdjd");
        finallyDemo.setThumb_media_id("hdjd");
        finallyDemo.setUrl("hdjd");
        finallyDemoList.add(finallyDemo);
        newsContent.setFinallyDemoList(finallyDemoList);

        item.setMedia_id("dhuwuw");
        item.setContent(newsContent);
        item.setUpdate_time("2020:12:16 14:12");
        itemList.add(item);

        newsRoot.setItem(itemList);
        newsRoot.setItem_count(20);
        newsRoot.setTotal_count(50);

        System.out.println(newsRoot.toString());
    }
}
