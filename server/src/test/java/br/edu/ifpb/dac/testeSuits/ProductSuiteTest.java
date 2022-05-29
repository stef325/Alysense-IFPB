package br.edu.ifpb.dac.testeSuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Product.ProductTestExceptionAndRequest;
import br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Product.ProductTestService;

@RunWith(Suite.class)
@SuiteClasses({ProductTestExceptionAndRequest.class,
    ProductTestService.class})
public class ProductSuiteTest {
    
}
