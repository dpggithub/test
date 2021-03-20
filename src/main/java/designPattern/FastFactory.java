package designPattern;

public class FastFactory implements FactoryP {
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument(md);
    }
    public HtmlDocument.WordDocument createWord(String md) {
        return new FastHtmlDocument(md);
    }
}
