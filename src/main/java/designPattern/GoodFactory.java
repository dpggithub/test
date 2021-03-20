package designPattern;

public class GoodFactory implements FactoryP {
    public HtmlDocument createHtml(String md) {
        return new GoodHtmlDocument(md);
    }
    public HtmlDocument.WordDocument createWord(String md) {
        return new GoodHtmlDocument(md);
    }
}
