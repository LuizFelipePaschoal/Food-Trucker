package br.com.project.foodtrucker.dto;

import br.com.project.foodtrucker.model.enums.TypeUsers;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginResponse {

    private String token;
    private TypeUsers type;

}
