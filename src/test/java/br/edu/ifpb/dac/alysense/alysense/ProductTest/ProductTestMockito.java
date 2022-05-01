package br.edu.ifpb.dac.alysense.alysense.ProductTest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;

public class ProductTestMockito{

    @Mock
    Product product;

/*@Test(expected= NullPointerException.class)
public void mockExceptiontest(){
    when(product.getId()).themThrow(new NullpointException())
    when(product.getName()).themThrow(new NullpointException())
    when(product.getCharacteristic()).themThrow(new NullpointException())
    when(product.getOwner).themThrow(new NullpointException())

    assertAll(() -> assertThrows(NullpointException.class, () -> product.getName()), () -> assertThrows(NullpointException.class, () ->product.getId()),
    assertThrows(NullpointException.class, ()-> product.getOwner()), assertThrows(NullpointException.class,()-> product.getCharacteristic()));
}*/
}