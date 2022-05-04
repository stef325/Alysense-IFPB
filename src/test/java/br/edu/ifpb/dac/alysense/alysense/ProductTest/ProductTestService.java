package br.edu.ifpb.dac.alysense.alysense.ProductTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.ProductDTO;
import br.edu.ifpb.dac.alysense.alysense.util.ProductWithSV;


public class ProductTestService{

    final ConverterService converter = new ConverterService();
 
    Product product= new Product();
    ProductDTO dto = new ProductDTO();;
    Set<Characteristic> characteristics = new HashSet<Characteristic>();
    Characteristic characteristic= new Characteristic();;

    

    @Before
    public void setUp(){
        product.setName("bolo");
        characteristic.setAtributes("doce");
        characteristics.add(characteristic);
        product.setCharacteristics(characteristics);
        product.setExpirationDate(LocalDate.now());
        product.setOwner("qualquer");
    }

    @Before
    public void setUpDTO(){
        dto.setName("coxinha");
        characteristic.setAtributes("salgado");
        characteristics.add(characteristic);
       product.setCharacteristics(characteristics);
       dto.setCharacteristics(characteristics);
        dto.setExpirationDate(LocalDate.now());
        dto.setOwner("qualquer");
    }

   
    
    @Test
    @Order(1)
    public void typeClassTest(){
        assertInstanceOf(ProductDTO.class, converter.ProductToDTO(new Product()));
        assertInstanceOf(Product.class, converter.DTOToProduct(new ProductDTO()));
        assertFalse(product.getClass().equals(ProductDTO.class));
    }

    @Test
    @Order(3)
    public void convertorTest(){
        ProductDTO dto = converter.ProductToDTO(product);
        Iterator<Characteristic> ite = dto.getCharacteristics().iterator();
        assertAll(() -> assertEquals("bolo",dto.getName()),
        () -> assertEquals("doce",ite.next().getAtributes()),
        () ->assertEquals("qualquer",dto.getOwner()),
        () -> assertEquals(LocalDate.now(),dto.getExpirationDate()));
        
    }

    @Test
    @Order(2)
    public void notNullTest(){
        ProductDTO dto = converter.ProductToDTO(product);
        assertAll(() -> assertNotNull(dto.getName()),
        () -> assertNotNull(dto.getCharacteristics()),
        () ->assertNotNull(dto.getOwner()),
        () -> assertNotNull(dto.getExpirationDate()));
    }

    @Test
    @Order(4)
    public void nullTest(){
        Product product = new Product();
        assertNull(product.getExpirationDate());
        assertNull(product.getId());
    }

    @Test
    @Order(5)
    public void localDateTests(){
        assertEquals(LocalDate.now(),product.getExpirationDate());
        product.setExpirationDate(LocalDate.parse("2022-10-10"));
        assertTrue(LocalDate.now().isBefore(product.getExpirationDate()));
        assertFalse(LocalDate.now().isAfter(product.getExpirationDate()));
    }

    @Test
    @Order(6)
    public void localDateTestsDTO(){
        assertEquals(LocalDate.now(),dto.getExpirationDate());
        dto.setExpirationDate(LocalDate.parse("2022-10-10"));
        assertTrue(LocalDate.now().isBefore(dto.getExpirationDate()));
        assertFalse(LocalDate.now().isAfter(dto.getExpirationDate()));
    }

    @Test
    @Order(7)
    public void atribuTestsToDTO(){
       ProductDTO dto = converter.ProductToDTO(product);
       assertEquals(dto.getId(), product.getId());
       assertEquals(dto.getName(), product.getName());
     assertEquals(dto.getCharacteristics(), product.getCharacteristics());
       assertEquals(dto.getExpirationDate(), product.getExpirationDate());
       assertEquals(dto.getOwner(), product.getOwner());
    }

    @Test
    @Order(8)
    public void atribuTestsToProduct(){
       Product product = converter.DTOToProduct(dto);
       assertEquals(dto.getId(), product.getId());
       assertEquals(dto.getName(), product.getName());
        assertEquals(dto.getCharacteristics(), product.getCharacteristics());
       assertEquals(dto.getExpirationDate(), product.getExpirationDate());
       assertEquals(dto.getOwner(), product.getOwner());
    }

    @ParameterizedTest
    @Order(9)
    @CsvSource({
        "Macarrão,2022-07-09, True",
        "Chocolate,2022-07-09, True",
        "Garrafa,2022-07-09, True"

    })
    public void sanitaryVigillanceTrue(ArgumentsAccessor arguments){
        ProductWithSV prod= new ProductWithSV();
        prod.setName(arguments.getString(0));
        prod.setExpirationDate(arguments.get(1, LocalDate.class));
        prod.setSVverified(arguments.get(2, Boolean.class));
        
        assertTrue(prod.getSVverified());
        
    }

    @ParameterizedTest
    @Order(9)
    @CsvSource({
        "Macarrão,2022-07-09, False",
        "Chocolate,2022-07-09, False",
        "Garrafa,2022-07-09, False"

    })
    public void sanitaryVigillanceFalse(ArgumentsAccessor arguments){
        ProductWithSV prod= new ProductWithSV();
        prod.setName(arguments.getString(0));
        prod.setExpirationDate(arguments.get(1, LocalDate.class));
        prod.setSVverified(arguments.get(2, Boolean.class));
        
        assertFalse(prod.getSVverified());
        
    }
}