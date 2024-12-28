package models;

import com.github.javafaker.Faker;
import lombok.*;
public class ProjectBuilder {

    static Faker faker = new Faker();

    /*public static Project get() {
        return Project
                .builder()
                .projectName("Demo")
                .projectCode(faker.code().asin())
                .build();
    }*/
}
