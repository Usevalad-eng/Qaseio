package tests.api.pojos.response.project.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    public int total;
    public int filtered;
    public int count;
    public ArrayList<Object> entities;
}
