package br.edu.ifpb.dac.alysense.alysense.business.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.business.service.interfaces.PasswordEncoderServiceIntrfc;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

@Service
public class PasswordEncoderService extends BCryptPasswordEncoder implements PasswordEncoderServiceIntrfc{

    @Override
    public void encryptPassword(User user) {
        if (user.getPassword() != null) {
            String encryptedPassword = encode(user.getPassword());
            user.setPassword(encryptedPassword);
        }
        
    }
    
}
