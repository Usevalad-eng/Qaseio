package models;


import lombok.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/*@Builder
@Data
@AllArgsConstructor*/

public class Project {

    private String projectName;
    private String projectCode;

    public Project(String projectName, String projectCode) {
        this.projectName = projectName;
        this.projectCode = projectCode;
    }

    public String getProjName() {
        return projectName;
    }

    public String getProjCode() {
        return projectCode;
    }
}
