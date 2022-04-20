package br.edu.ifpb.dac.testeSuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.edu.ifpb.dac.alysense.alysense.Event.EventsTests;
import br.edu.ifpb.dac.alysense.alysense.ProductTest.ProductTestExceptionAndRequest;
import br.edu.ifpb.dac.alysense.alysense.ProductTest.ProductTestService;
import br.edu.ifpb.dac.alysense.alysense.User.UserTests;

@RunWith(Suite.class)
@SuiteClasses({ProductTestExceptionAndRequest.class,
    ProductTestService.class, UserTests.class, EventsTests.class})
public class generalTestSuit {
    
}
