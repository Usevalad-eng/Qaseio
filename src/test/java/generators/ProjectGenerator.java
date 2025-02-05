package generators;

import com.github.javafaker.Faker;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.steps.ProjectSteps;

public class ProjectGenerator {

    static Faker faker = new Faker();

    public static CreateProjectRequest createProjectApi(){
        return CreateProjectRequest.builder()
                .title(faker.name().firstName())   //todo: name must be < 10 symbols
                .code(faker.name().firstName().toUpperCase())
                .description(faker.chuckNorris().fact())
                .access("all")
                .group(faker.name().firstName())
                .build();
    }

    /*public static CreateProjectRequest createProjectApiH(){
            return CreateProjectRequest.builder()
                    .title(faker.name().firstName())
                    .code("DDD")
                    .description(faker.chuckNorris().fact())
                    .access("all")
                    .group(faker.name().firstName())
                    .build();
        }*/

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
