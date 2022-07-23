package br.edu.ifpb.dac.alysense.alysense.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.edu.ifpb.dac.alysense.alysense.business.service.AuthenticationService;
import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.business.service.UserService;
import br.edu.ifpb.dac.alysense.alysense.business.service.TokenService.TokenService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.LoginDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.TokenDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;


@RestController
@RequestMapping("/api")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private ConverterService converterService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO dto){
        try {
            String token = authService.login(dto.getUsername(), dto.getPassword());
            User entity = userService.findByUseName(dto.getUsername());
            UserDTO userDTO = converterService.converterToDTO(entity);

            TokenDTO tokenDTO = new TokenDTO(token,userDTO);
            
            return new ResponseEntity(tokenDTO, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/isTokenValid")
    public ResponseEntity isTokenValid(@RequestBody TokenDTO dto){
        try {
            boolean isTokenValid = tokenService.isValid(dto.getToken());
            
            return new ResponseEntity(isTokenValid, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    
}
