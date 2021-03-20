package designPattern;

import java.io.IOException;
import java.nio.file.Path;

public class GoodHtmlDocument implements HtmlDocument, HtmlDocument.WordDocument {
    public GoodHtmlDocument(String md) {
    }

    public String toHtml() {
       return "";
    }
    public void save(Path path) throws IOException {
        return;
    }

    public void saves(Path path) throws IOException {
        return;
    }
}
