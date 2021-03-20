package designPattern;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * 工厂模式
 */
public interface FactoryP {
    public static FactoryP createFactory(String name){
        if(name.equalsIgnoreCase("fast")){
            return new FastFactory();
        }else if(name.equalsIgnoreCase("good")){
            return new GoodFactory();
        }else {
            throw new IllegalArgumentException("Invalid factory name!");
        }
    }

    public static void main(String[] args) throws IOException {
        FastFactory fastFactory = (FastFactory) FactoryP.createFactory("fast");
        HtmlDocument html =fastFactory.createHtml("#Hello\nHello, world!");
        html.save(Paths.get(".", "fast.html"));

        HtmlDocument.WordDocument word = fastFactory.createWord("#Hello\nHello, world!");
        word.saves(Paths.get(".", "fast.doc"));
    }
}
