package br.com.project.foodtruck.dto;

import br.com.project.foodtruck.model.enums.TypeUsers;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginResponse {

    private String token;
    private TypeUsers type;

}
