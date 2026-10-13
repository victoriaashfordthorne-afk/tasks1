package MbemX.example.secondprojectmbemx.Controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {

    private final String appName;
    private final String appVersion;

    public InfoController(@Value("${spring.application.name}") String appName,
                          @Value("${app.version}") String appVersion) {
        this.appName = appName;
        this.appVersion = appVersion;
    }

    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of(
                "application", appName,
                "version", appVersion
        );
    }
}
