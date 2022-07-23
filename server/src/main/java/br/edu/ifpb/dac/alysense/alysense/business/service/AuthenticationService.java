package br.edu.ifpb.dac.alysense.alysense.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.business.service.TokenService.TokenService;
import br.edu.ifpb.dac.alysense.alysense.business.service.interfaces.AuthenticationServiceIntrfc;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

@Service
public class AuthenticationService implements AuthenticationServiceIntrfc{

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authManager;

    @Override
    public String login(String username, String password) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        User user = userService.findByUseName(username);
        return tokenService.generate(user);
    }

    @Override
    public User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (User) auth.getPrincipal();
    }
    
}
