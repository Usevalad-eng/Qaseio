package models;

import com.github.javafaker.Faker;

public class CaseBuilder {

    static Faker faker = new Faker();

    public static Case get() {
        return Case
                .builder()
                .caseName(faker.code().asin())
                .build();
    }

    public static Case getAllFields() {
        return Case
                .builder()
                .caseName(faker.code().asin())
                .stepAction("action")
                .stepResult("result")
                .build();
    }
}
