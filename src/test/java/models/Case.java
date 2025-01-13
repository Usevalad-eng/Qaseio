package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Case {

    private String caseName;

    /*public Case(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseName() {
        return caseName;
    }*/
}
