package watchDog.shellWatchDog;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Data
@Configuration
@ConfigurationProperties(prefix = "shell")
public class ShellProperties {

    private String directory;

    private String startupFileName;

    private String restartFileName;

    /* getter & setter */

    public String getFullName(String fileName) {
        return directory + "/" + fileName;
    }
}
