package br.edu.ifpb.dac.alysense.alysense.User;



import java.time.LocalDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class UserTests {

    @ParameterizedTest
    @CsvSource({
	    "1990-05",
	    "1990-10"
	})
    void UserAge(ArgumentsAccessor arguments) {
        
    }
    
}
