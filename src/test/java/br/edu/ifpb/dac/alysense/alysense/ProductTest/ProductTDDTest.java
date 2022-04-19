package br.edu.ifpb.dac.alysense.alysense.ProductTest;

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
}