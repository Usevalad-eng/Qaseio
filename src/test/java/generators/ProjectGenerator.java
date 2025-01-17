package generators;

import com.github.javafaker.Faker;
import tests.api.pojos.request.project.CreateProjectRequest;

public class ProjectGenerator {

    static Faker faker = new Faker();

    public static CreateProjectRequest createProjectApi(){
        return CreateProjectRequest.builder()
                .title(faker.name().firstName())
                .code(faker.name().firstName().toUpperCase())
                .description(faker.chuckNorris().fact())
                .access("all")
                .group(faker.name().firstName())
                .build();
    }
}
