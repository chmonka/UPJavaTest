package model.requestModal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestLogin {
    public String email;
    public String password;

    public RequestLogin(String email) {
        this.email = email;
    }
}
