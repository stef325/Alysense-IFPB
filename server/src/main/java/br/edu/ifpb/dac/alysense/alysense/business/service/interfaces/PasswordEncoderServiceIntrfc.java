package br.edu.ifpb.dac.alysense.alysense.business.service.interfaces;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

public interface PasswordEncoderServiceIntrfc extends PasswordEncoder{

    void encryptPassword(User user);
    
}
