package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.User;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.business.service.ValidationAgeUserService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;
import br.edu.ifpb.dac.alysense.alysense.util.UserToTest;
import br.edu.ifpb.dac.alysense.alysense.util.UserValidations;

public class UserTests {
    final UserToTest NotActualUser = new UserToTest();
    final UserToTest NotActualUser2 = new UserToTest();
    final User implementedUser = mock(User.class);
    final UserDTO dto = new UserDTO();



    @Before
    public final void initUser(){
        List<String> okProducts = new ArrayList<>();
        okProducts.add("Laranja");
        okProducts.add("Shampoo");
        okProducts.add("Garrafa");
        okProducts.add("Peruca");

        List<String> okProducts2 = new ArrayList<>();
        okProducts2.add("Macarrão");
        okProducts2.add("Shampoo");
        okProducts2.add("Garrafa");
        okProducts2.add("Peruca");

        NotActualUser.setOkProducts(okProducts);
        NotActualUser2.setOkProducts(okProducts2);

        implementedUser.setName("james");
        implementedUser.setPassword("1234");
        dto.setName("james");
        dto.setPassword("1234");

    }


   
    @Test
    @DisplayName("Age should be higher than")
    public void UserAge() {
        LocalDate birthDate = LocalDate.now().minusYears(19);

        assertEquals(true, ValidationAgeUserService.isAgeEnoughToVote(19, birthDate.minusMonths(1)));
        assertEquals(true, ValidationAgeUserService.isAgeEnoughToVote(19, birthDate));
        assertEquals(false, ValidationAgeUserService.isAgeEnoughToVote(19, birthDate.plusMonths(1)));
    }

    @Test
    @DisplayName("products restrictions")
    public void UserCanUse(){
        EvaluateItem itemMock = mock(EvaluateItem.class);

        Product prod = new Product();
        prod.setName("Macarrão");
        
        when(itemMock.getProduct()).thenReturn(prod);
        
        assertEquals(false, UserValidations.canUse(itemMock.getProduct().getName(), NotActualUser.getOkProducts()));
        assertEquals(true, UserValidations.canUse(itemMock.getProduct().getName(), NotActualUser2.getOkProducts()));

        verify(itemMock, atLeastOnce()).getProduct();
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
