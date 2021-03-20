package designPattern;

import java.io.IOException;
import java.nio.file.Path;

// Html文档接口:
public interface HtmlDocument {
    String toHtml();
    void save(Path path) throws IOException;

    // Word文档接口
    interface WordDocument {
        void saves(Path path) throws IOException;
    }
}
