package tests.api.pojos.response.suite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tests.api.pojos.response.project.Result;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSuiteResponse {

    public boolean status;
    public Result result;
}
