package tests.api.pojos.response.project.get;

//import com.fasterxml.jackson.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetProjResponse {

    public boolean status;
    //@JsonProperty("result")
    public Result result;
    public String errorMessage;
    public ArrayList<ErrorField> errorFields;
}
