package generators;

import com.github.javafaker.Faker;
import tests.api.pojos.request.suite.CreateSuiteRequest;

public class SuiteGenerator {

    static Faker faker = new Faker();

    public static CreateSuiteRequest createSuiteApi(){
        return CreateSuiteRequest.builder()
                .title(faker.name().firstName())
                .build();
    }
}
