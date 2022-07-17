package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO {

    private String token;
    private UserDTO user;
}