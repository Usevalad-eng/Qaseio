package generators;

import com.github.javafaker.Faker;
import tests.api.pojos.request.cases.CreateCaseRequest;

public class CaseGenerator {

    static Faker faker = new Faker();

    public static CreateCaseRequest createCaseApi(){
        return CreateCaseRequest.builder()
                .title(faker.name().firstName())
                .build();
    }
}
