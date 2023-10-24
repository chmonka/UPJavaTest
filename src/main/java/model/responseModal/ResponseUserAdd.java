package model.responseModal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserAdd {
    public Integer id;
    public String token;
    public String error;
}
