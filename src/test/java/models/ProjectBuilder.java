package models;

import com.github.javafaker.Faker;
import lombok.*;
public class ProjectBuilder {

    static Faker faker = new Faker();

    public static Project get() {
        return Project
                .builder()
                .projectName("Demo")
                .projectCode("DEMO")
                .build();
    }

    public static Project getTwo() {
        return Project
                .builder()
                .projectName(faker.code().asin())
                .projectCode(faker.name().firstName())
                .build();
    }
}
