package uz.pdp.homework1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotNull(message = "bomba bosh bolmasligi kere")
    private String fullName;
    @NotNull(message = "bomba bosh bolmasligi kere")
    private String userName;
    @NotNull(message = "bomba bosh bolmasligi kere")
    private String password;
    @NotNull(message = "bomba bosh bolmasligi kere")
    private String prePassword;
}
