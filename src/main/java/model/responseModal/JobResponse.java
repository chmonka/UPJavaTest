package model.responseModal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
    public Date updatedAt;

}
