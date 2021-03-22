package za.co.absa.avaf.dashboardbff.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties("avaf")
public class TopicNames {

    private Map<String, String> topicNames;

    public String get(final String name) {
        return topicNames.get(name);
    }
}
