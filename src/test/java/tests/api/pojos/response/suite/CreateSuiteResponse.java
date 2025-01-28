package tests.api.pojos.response.suite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSuiteResponse {

    public boolean status;
    public ResultS result;
}
