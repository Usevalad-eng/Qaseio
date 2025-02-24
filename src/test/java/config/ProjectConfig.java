package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:config/project.properties"
})
public interface ProjectConfig extends Config {

    String baseUrl();
    Long timeout();
}
