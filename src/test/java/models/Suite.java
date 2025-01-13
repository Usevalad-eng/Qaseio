package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Suite {

    private String suiteName;

    /*public Suite(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getSuiteName() {
        return suiteName;
    }*/
}
