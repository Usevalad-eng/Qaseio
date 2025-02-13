package generators;

import com.github.javafaker.Faker;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.steps.ProjectSteps;

public class ProjectGenerator {

    static Faker faker = new Faker();

    public static CreateProjectRequest createProjectApi(){   //todo: name must be < 10 symbols
        return CreateProjectRequest.builder()
                .title(faker.name().firstName())
                .code(faker.name().firstName().toUpperCase())
                .description(faker.chuckNorris().fact())
                .access("all")
                .group(faker.name().firstName())
                .build();
    }

    public static void createProjApi(){
        ProjectSteps.createProject(createProjectApi());
    }

    public static void getProjectCreated(CreateProjectRequest project){
        ProjectSteps.createProject(project);
    }

    public static void deleteProjectApi(String code){
        ProjectSteps.deleteProject(code);
    }
}
