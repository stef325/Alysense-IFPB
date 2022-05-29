package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;

public class ProductTDDTest{
    final Avaliar avaliar = new Avaliar();
    final Categoria categoria = new Categoria();

    @Test
    public void avaliarTest(){
        assertEquals("muito bom",avaliar.getMedia());
        assertTrue(avaliar.getMedia().contains("bom"));
        assertFalse(avaliar.getMedia().equals("ruim"));
    }

    @Test
    public void categoriaTest(){
        assertEquals("medio",categoria.getGosto());
        assertTrue(categoria.getCheiro().contains("ruim"));
        assertFalse(categoria.getVisual().contains("bom"));
    }

    @Test
    public void categoriaProductTest(){
        assertNull(categoria.getProduto());
        categoria.setProduto(new Product());
        assertNotNull(categoria.getProduto());
    }

    @Test
    public void avaliarProductTest(){
        assertNull(avaliar.getProduto());
        avaliar.setProduto(new Product());
        assertNotNull(avaliar.getProduto());
    }

     /*@Test
        @ValueSource(strings = { "bolo", "coxinha", "pastel", "ovo de chocolate", "panetone" })
    public void testAula(String name){
        product.setName(name);
        assertNotNull(product.getName())
        assertNotEquals(prego, product.getName());
        assertEquals(name, product.getName());
    }
    @Test
    public void testAltDatesBefore(){
        assertAll(() -> assertEquals(LocalDate.now().isBefore("2022-10-10") ,product.getExpirationDate()
        , () -> assertEquals(LocalDate.now().isBefore("2022-9-9") ,product.getExpirationDate(),
        () -> assertEquals(LocalDate.now().isBefore("2022-10-10") ,product.getExpirationDate()))
    }
    public void testAltDatesAfter(){
        assertAll(() -> assertEquals(LocalDate.now().isBefore("2022-10-10") ,product.getExpirationDate()
        , () -> assertEquals(LocalDate.now().isAfter("2021-9-9") ,product.getExpirationDate(),
        () -> assertEquals(LocalDate.now().isAfter("2021-10-10") ,product.getExpirationDate()))
    }

    */
}