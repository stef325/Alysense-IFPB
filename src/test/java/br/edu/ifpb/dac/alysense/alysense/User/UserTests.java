package br.edu.ifpb.dac.alysense.alysense.User;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;
import br.edu.ifpb.dac.alysense.alysense.util.UserToTest;
import br.edu.ifpb.dac.alysense.alysense.util.UserValidations;

public class UserTests {
    final UserToTest NotImplementedUser = new UserToTest();
    final User implementedUser = new User();
    final UserDTO dto = new UserDTO();

    ConverterService converter = new ConverterService();

    @Before
    public final void initUser(){
        List<String> okProducts = new ArrayList<>();
        okProducts.add("Macarrão");
        okProducts.add("Shampoo");
        okProducts.add("Garrafa");
        okProducts.add("Peruca");

        NotImplementedUser.setOkProducts(okProducts);

        implementedUser.setName("james");
        implementedUser.setPassword("1234");
        dto.setName("james");
        dto.setPassword("1234");

    }


   
    @Test
    @DisplayName("Age should be higher than")
    public void UserAge() {
        assertEquals(true, UserValidations.isAgeEnoughToVote(19, LocalDate.of(2003, 03, 19)));
        assertEquals(true, UserValidations.isAgeEnoughToVote(19, LocalDate.of(2003, 04, 19)));
        assertEquals(false, UserValidations.isAgeEnoughToVote(19, LocalDate.of(2003, 05, 19)));
    }

    @Test
    @DisplayName("products restrictions")
    public void UserCanUse(){
        assertEquals(false, UserValidations.canUse("Carne", NotImplementedUser.getOkProducts()));
        assertEquals(false, UserValidations.canUse("Macarrao", NotImplementedUser.getOkProducts()));
        assertEquals(true, UserValidations.canUse("Garrafa", NotImplementedUser.getOkProducts()));
        assertEquals(true, UserValidations.canUse("Shampoo", NotImplementedUser.getOkProducts()));
    }
    
    @Test
    @DisplayName("To DTO & ToUser")
    public void convertionPass(){
        assertNull(converter.conversorToDTO(implementedUser).getPassword());
        assertNotNull(converter.conversorToUser(dto).getPassword());
    }

    @Test
    @DisplayName("To DTO & To User class")
    public void convertionClass(){
        assertInstanceOf(UserDTO.class, converter.conversorToDTO(implementedUser));
        assertInstanceOf(User.class, converter.conversorToUser(dto));
    }



}
