package designPattern;

import java.io.IOException;
import java.nio.file.Path;

public class FastHtmlDocument implements HtmlDocument, HtmlDocument.WordDocument{
    public FastHtmlDocument(String md) {
    }

    public String toHtml() {
        return "";
    }
    public void save(Path path) throws IOException {

    }

    public void saves(Path path) throws IOException {
    }
}
