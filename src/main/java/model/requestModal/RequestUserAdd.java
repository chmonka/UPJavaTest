package model.requestModal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserAdd {
    public String email;
    public String password;

    public RequestUserAdd(String email) {
        this.email = email;
    }

}
