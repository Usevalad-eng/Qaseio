package models;


import lombok.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@Builder
@AllArgsConstructor
public class Project {

    private String projectName;
    private String projectCode;
}
