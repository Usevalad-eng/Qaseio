package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:config/api.properties"
})
public interface ApiConfig extends Config {

    String token();
    String baseUri();
    String basePath();
}
