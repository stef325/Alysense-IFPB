package br.edu.ifpb.dac.alysense.alysense.Integration.ThirdPartyServices.util;

import static org.mockito.Mockito.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.business.service.ProductService;
import br.edu.ifpb.dac.alysense.alysense.util.ProductWithSV;

@Service
public class ProductValidationService {



    public ProductWithSV Validate( ProductWithSV prod, SanitaryVigilance SV){
        if (SV.ValidateProduct(prod.getCode(), prod.getLote())) {
            prod.setSVverified(true);

            return prod; //simular update no service
        }
        return prod;
        

    }
    
}
