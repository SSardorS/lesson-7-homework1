package uz.pdp.homework1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String fullName;

    private String userName;

    private String password;

    private Long roleId;
}
