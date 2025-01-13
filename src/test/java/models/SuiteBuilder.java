package models;

import com.github.javafaker.Faker;

public class SuiteBuilder {

    static Faker faker = new Faker();

    public static Suite get() {
        return Suite
                .builder()
                .suiteName(faker.code().asin())
                .build();
    }
}
