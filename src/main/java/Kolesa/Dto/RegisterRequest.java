package Kolesa.Dto;

import Kolesa.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String contact;
}
