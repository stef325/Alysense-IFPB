package br.edu.ifpb.dac.alysense.alysense.Integration.User;

import static org.junit.Assert.assertSame;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.dac.alysense.alysense.business.service.UserService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

public class UserServiceTests {
    
    private UserService service;

    @Before
    public void initService(){
        service = new UserService();

    }

    //@Test
    public void serviceCreate(){
        User user = new User();
        user.setName("Bruna");
        user.setBirthDate(LocalDate.of(2003, 03, 29));
        user.setPassword("123123123123");
        user.setId(1l);
        user.setEmail("bruna@gmail.com");

        User savedUser = service.save(user);

        assertSame(savedUser, user);

    }

}
