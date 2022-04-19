package br.edu.ifpb.dac.alysense.alysense.ProductTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import br.edu.ifpb.dac.alysense.alysense.business.service.ProductService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.presentation.controller.ProductController;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.ProductDTO;

public class ProductTestExceptionAndRequest{

    final ProductService service = new ProductService();
    final Product product = new Product();
    final ProductController controller = new ProductController();

    @Test
    public void crudTestException(){
        assertThrows(NullPointerException.class,() -> service.save(product));
        assertThrows(NullPointerException.class,() -> service.delete((long) 1));
        assertThrows(NullPointerException.class,() -> service.find(product));
        assertThrows(NullPointerException.class,() -> service.update(product));
    }

    @Test
    public void statusTest(){
        assertEquals(400,controller.findAll().getStatusCodeValue());
        assertEquals(400,controller.delete((long) 1).getStatusCodeValue());
        assertEquals(400,controller.save(new ProductDTO()).getStatusCodeValue());
    }

}