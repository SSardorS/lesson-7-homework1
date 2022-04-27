package uz.pdp.homework1.payload;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDto {


    @NotNull(message = "bomba bosh bolmasligi kere")
    private String userName;
    @NotNull(message = "bomba bosh bolmasligi kere")
    private String password;
}
