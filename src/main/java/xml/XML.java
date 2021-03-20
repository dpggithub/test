package xml;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringEscapeUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import redis.model.User;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XML {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String,String> map =xmlToMap("src/main/resources/mapper/UserMapper.xml");
        for(Map.Entry<String,String> m: map.entrySet()){
            System.out.println("key = " + m.getKey() + ", value = " + m.getValue());
        }

        User user =new User();
        user.setId(123456L);
        user.setUserName("doctor");
        user.setPassWord("123kdllkdl");
        System.out.println(sendText(user.getId(), user.getUserName(), user.getPassWord()));

//        // 解析books.xml文件
//        // 创建SAXReader的对象reader
//        SAXReader reader = new SAXReader();
//        try {
//            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
//            Document document = reader.read(new File("src/main/resources/mapper/UserMapper.xml"));
//            // 通过document对象获取根节点bookstore
//            Element bookStore = document.getRootElement();
//            // 通过element对象的elementIterator方法获取迭代器
//            Iterator it = bookStore.elementIterator();
//            // 遍历迭代器，获取根节点中的信息（书籍）
//            while (it.hasNext()) {
//                System.out.println("=====开始遍历某一本书=====");
//                Element book = (Element) it.next();
//                // 获取book的属性名以及 属性值
//                List<Attribute> bookAttrs = book.attributes();
//                for (Attribute attr : bookAttrs) {
//                    System.out.println("属性名：" + attr.getName() + "--属性值："
//                            + attr.getValue());
//                }
//                Iterator itt = book.elementIterator();
//                while (itt.hasNext()) {
//                    Element bookChild = (Element) itt.next();
//                    System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
//                }
//                System.out.println("=====结束遍历某一本书=====");
//            }
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }

    }

    public static Map<String,String> xmlToMap(String filePath) throws FileNotFoundException {
        Map<String, String> map = new HashMap<>(8);
        SAXReader reader = new SAXReader();
        File file =new File(filePath);
        try(InputStream inputStream =new FileInputStream(file)) {
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> list = root.elements();
            for (Element element : list) {
                map.put(element.getName(), element.getText());
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String toXML(User user){
        XStream xStream = new XStream();
        xStream.alias("xml",User.class);
        return xStream.toXML(user);
    }

    public static String sendText(long id,String userName,String passWord){
        User user = new User();
        user.setId(id);
        user.setUserName("<![CDATA["+ userName + "]]>");
        user.setPassWord("<![CDATA["+ passWord + "]]>");
        return StringEscapeUtils.unescapeXml(toXML(user));
    }
}
