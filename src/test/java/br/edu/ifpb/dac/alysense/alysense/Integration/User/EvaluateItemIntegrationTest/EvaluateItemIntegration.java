package br.edu.ifpb.dac.alysense.alysense.Integration.User.EvaluateItemIntegrationTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.ifpb.dac.alysense.alysense.business.service.EvaluateItemService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.AspectAvaliation;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.repository.EvaluateItemRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.EvalueteItemController;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EvaluateItemDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EvaluateItemIntegration {

    @Autowired
    EvalueteItemController controller;

    @Autowired
    EvaluateItemService service;

    @Autowired
    EvaluateItemRepository repository;

    EvaluateItemDTO dto;

    EvaluateItem entity;

    @Before
    public void setUp(){
        dto = new EvaluateItemDTO();
        entity = new EvaluateItem();
    }


    @Test
    public void createTest(){
        ResponseEntity res = controller.save(dto);
        assertEquals(HttpStatus.CREATED, res.getStatusCode());
        assertEquals(EvaluateItemDTO.class, res.getBody().getClass());
    }
    

    @Test
    public void findTest(){
        service.save(entity);
        EvaluateItemDTO dtoCompare = service.findById(entity.getId());

        assertNull(dtoCompare.getAspectAvaliation());
        assertNull(dtoCompare.getProduct());
        assertEquals(entity.getId(), dtoCompare.getId());
    }

    @Test
    public void findAtributeTest(){
        entity = new EvaluateItem();

        Product product = new Product();
        product.setName("Pizza");
        product.setOwner("qualquer");
        entity.setProduct(product);

        AspectAvaliation as = new AspectAvaliation();
        entity.setAspectAvaliation(as);

        service.save(entity);
        EvaluateItemDTO dtoCompare = service.findById(entity.getId());

        assertAll(() -> assertEquals(entity.getProduct().getId(), dtoCompare.getProduct().getId()),() ->
        assertEquals(entity.getProduct().getName(), dtoCompare.getProduct().getName()), ()->
        assertEquals(entity.getProduct().getOwner(), dtoCompare.getProduct().getOwner()), ()-> 
        assertNull(dtoCompare.getProduct().getExpirationDate()));

        assertNotNull(dtoCompare.getAspectAvaliation());

    }

    @Test
    public void updateTest(){
        service.save(entity);
        Product product = new Product();

        product.setName("Pizza");
        entity.setProduct(product);

        service.update(entity);
        EvaluateItemDTO dtoCompore = service.findById(entity.getId());

        assertNotNull(dtoCompore);
        assertEquals(product.getName(), dtoCompore.getProduct().getName());
    }

    @Test
    public void deleteTest(){
        entity = new EvaluateItem();
        service.save(entity);
        ResponseEntity res = controller.delete(entity.getId());

        assertEquals(HttpStatus.NO_CONTENT,res.getStatusCode());
    }

    
}
