package br.edu.ifpb.dac.alysense.alysense.Integration.ThirdPartyServices;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifpb.dac.alysense.alysense.Integration.ThirdPartyServices.util.ProductValidationService;
import br.edu.ifpb.dac.alysense.alysense.Integration.ThirdPartyServices.util.SanitaryVigilance;
import br.edu.ifpb.dac.alysense.alysense.util.ProductWithSV;

@SpringBootTest
public class SVTests {

    private SanitaryVigilance SV = mock(SanitaryVigilance.class);
    private ProductWithSV product;
    private ProductValidationService service = mock(ProductValidationService.class);

    @Before
    public void init(){
        service = new ProductValidationService();
        product = new ProductWithSV();
        product.setCode(131231l);
        product.setLote(3l);
        product.setSVverified(false);

        when(SV.ValidateProduct(product.getCode(), product.getLote())).thenReturn(true);

    }

    @Test
    @Order(1)
    public void validate(){
        assertTrue(SV.ValidateProduct(131231l, 3l));

        verify(SV).ValidateProduct(131231l, 3l);
    }

    @Test
    @Order(2)
    public void validateWithService(){
        

        assertTrue(SV.ValidateProduct(product.getCode(), product.getLote()));

        assertAll(
            () -> assertEquals(131231l, product.getCode()),
            () -> assertEquals(3l, product.getLote()),
            () -> assertFalse(product.getSVverified())
        );

        
        ProductWithSV prod = service.Validate(product,SV);
        

        assertAll(
            () -> assertEquals(131231l, prod.getCode()),
            () -> assertEquals(3l, prod.getLote()),
            () -> assertTrue(prod.getSVverified())
        );

        verify(SV, times(2)).ValidateProduct(131231l, 3l);
        
    }
    
}
