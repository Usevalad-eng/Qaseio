package tests.api.pojos.response.cases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCaseResponse {

    private boolean status;
    public ResultC result;
    private String errorMessage;
}
