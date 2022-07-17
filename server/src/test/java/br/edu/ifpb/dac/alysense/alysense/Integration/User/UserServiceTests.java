package br.edu.ifpb.dac.alysense.alysense.Integration.User;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;



import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.business.service.UserService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.model.repository.UserRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.UserController;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;

@SpringBootTest
public class UserServiceTests {
    
    @Autowired
    private UserService service;

    @Autowired
    private UserController controller;

    @Autowired
    private UserRepository repository;

   

    private User user;

    @BeforeEach
    public void init(){
        user = new User();
        user.setName("Bruna");
        user.setBirthDate(LocalDate.of(2003, 03, 29));
        user.setPassword("123123123123");
        user.setEmail("bruna@gmail.com");
    }

    @Test
    @Order(1)
    public void DB(){
        
        User savedUser = repository.save(user);
        
        assertEquals(savedUser.getEmail(), user.getEmail());

        UserDTO DBUser = service.findByIdDTO(savedUser.getId());

        assertAll(
            () -> assertEquals(savedUser.getName(), DBUser.getName()),
            () -> assertEquals(savedUser.getId(), DBUser.getId()),
            () -> assertEquals(savedUser.getEmail(), DBUser.getEmail()),
            () -> assertNull(DBUser.getPassword())
        );
    }



    @Test
    @Order(2)
    public void service(){
        User savedUser = service.save(user);
        assertEquals(savedUser.getEmail(), user.getEmail());

        UserDTO DBUser = service.findByIdDTO(savedUser.getId());

        assertAll(
            () -> assertEquals(savedUser.getName(), DBUser.getName()),
            () -> assertEquals(savedUser.getId(), DBUser.getId()),
            () -> assertEquals(savedUser.getEmail(), DBUser.getEmail()),
            () -> assertNull(DBUser.getPassword())
        );
    }

    @Test
    @Order(3)
    public void serviceAndController(){
        UserDTO user = new UserDTO();
        user.setName("Bruna");
        user.setBirthDate(LocalDate.of(2003, 03, 29));
        user.setPassword("123123123123");
        user.setEmail("bruna@gmail.com");

        ResponseEntity response = controller.save(user);

        
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());

        UserDTO BodyResponse = (UserDTO) response.getBody();
        UserDTO DBUser = service.findByIdDTO(BodyResponse.getId());

        assertAll(
            () -> assertEquals(BodyResponse.getName(), DBUser.getName()),
            () -> assertEquals(BodyResponse.getId(), DBUser.getId()),
            () -> assertEquals(BodyResponse.getEmail(), DBUser.getEmail()),
            () -> assertNull(BodyResponse.getPassword()),
            () -> assertNull(DBUser.getPassword())
        );
    }

    @Test
    @Order(4)
    public void serviceControllerAndConverter(){
        UserDTO userdto = ConverterService.converterToDTO(user);

        ResponseEntity response = controller.save(userdto);

        
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());

        UserDTO BodyResponse = (UserDTO) response.getBody();
        UserDTO DBUser = service.findByIdDTO(BodyResponse.getId());

        assertAll(
            () -> assertEquals(BodyResponse.getName(), DBUser.getName()),
            () -> assertEquals(BodyResponse.getId(), DBUser.getId()),
            () -> assertEquals(BodyResponse.getEmail(), DBUser.getEmail()),
            () -> assertNull(BodyResponse.getPassword()),
            () -> assertNull(DBUser.getPassword())
        );
    }

    @Test
    @Order(5)
    public void update(){
        UserDTO userdto = ConverterService.converterToDTO(user);
        userdto.setEmail("bruna123321@gmail.com");

        ResponseEntity response = controller.update(11L,userdto);

        assertEquals(200, response.getStatusCodeValue());

        UserDTO DBUser = service.findByIdDTO(11L);

        assertEquals(userdto.getEmail(), DBUser.getEmail());

    }

    @Test
    @Order(6)
    public void delete(){
        UserDTO userdto = ConverterService.converterToDTO(user);

        ResponseEntity response = controller.delete(17L);

        assertEquals(204, response.getStatusCodeValue());

        ResponseEntity response2 = controller.delete(17L);

        assertEquals(400, response2.getStatusCodeValue());

    }


}
