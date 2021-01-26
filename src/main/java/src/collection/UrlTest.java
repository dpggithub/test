package src.collection;

import exception.BusinessException;

import java.nio.charset.StandardCharsets;

public class UrlTest {
    public static void main(String[] args) {
        String url="http://mp.weixin.qq.com/s?__biz=MzI2MjAxMTk1OA==&mid=100000208&idx=1&sn=46cc63b956f09bcf8920c0c7d67a66e4&chksm=6a50ec895d27659f53f772455020d3230645ef924747290ab730148938dd602ab74e97fcfee2#rd";
         byte[] bytes= url.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
            if (bytes.length > 1024) {
                throw new BusinessException("您输入的一级菜单url超过指定长度，请重新输入！");
            }
        }
    }

