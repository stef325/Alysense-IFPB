package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Characteristic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;
import br.edu.ifpb.dac.alysense.alysense.util.InvalidCharacterException;

public class CharacteristicTests {
    

    @Test
    public void isString(){
        Characteristic caract = mock(Characteristic.class);

        when(caract.getAtribute()).thenReturn("Gelado");
        assertEquals(String.class, caract.getAtribute().getClass());
        verify(caract).getAtribute();
    }

    @Test
    public void containsInvalidCharacter() throws InvalidCharacterException{

        

        CharacteristcToTest caract = mock(CharacteristcToTest.class);
        doThrow(new InvalidCharacterException()).when(caract).setName("%");

        assertThrows(InvalidCharacterException.class,()->caract.setName("%"));

        verify(caract, atLeastOnce()).setName("%");

    }
}
