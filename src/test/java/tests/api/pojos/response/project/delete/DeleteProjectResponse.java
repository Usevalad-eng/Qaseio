package tests.api.pojos.response.project.delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProjectResponse {

    private boolean status;
    private String errorMessage;
}
