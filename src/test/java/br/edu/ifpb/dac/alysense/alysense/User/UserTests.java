package br.edu.ifpb.dac.alysense.alysense.User;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.business.service.ValidationAgeUserService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;
import br.edu.ifpb.dac.alysense.alysense.util.UserToTest;
import br.edu.ifpb.dac.alysense.alysense.util.UserValidations;

public class UserTests {
    final UserToTest NotImplementedUser = new UserToTest();
    final User implementedUser = mock(User.class);
    final UserDTO dto = new UserDTO();


    ValidationAgeUserService UserValidationService = new ValidationAgeUserService();

    @Before
    public final void initUser(){
        List<String> okProductsMock = new ArrayList<>();
        okProductsMock.add("Macarrão");
        okProductsMock.add("Shampoo");
        okProductsMock.add("Garrafa");
        okProductsMock.add("Peruca");

        NotImplementedUser.setOkProducts(okProductsMock);

        implementedUser.setName("james");
        implementedUser.setPassword("1234");
        dto.setName("james");
        dto.setPassword("1234");

    }


   
    @Test
    @DisplayName("Age should be higher than")
    public void UserAge() {
        LocalDate birthDate = LocalDate.now().minusYears(19);
        System.out.println(birthDate.toString());
        assertEquals(true, UserValidationService.isAgeEnoughToVote(19, LocalDate.of(2003, 03, 19)));
        assertEquals(true, UserValidationService.isAgeEnoughToVote(19, birthDate));
        assertEquals(false, UserValidationService.isAgeEnoughToVote(19, birthDate.plusMonths(1)));
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
        assertNull(ConverterService.conversorToDTO(implementedUser).getPassword());
        assertNotNull(ConverterService.conversorToUser(dto).getPassword());
    }

    @Test
    @DisplayName("To DTO & To User class")
    public void convertionClass(){
        assertInstanceOf(UserDTO.class, ConverterService.conversorToDTO(implementedUser));
        assertInstanceOf(User.class, ConverterService.conversorToUser(dto));
    }



}
