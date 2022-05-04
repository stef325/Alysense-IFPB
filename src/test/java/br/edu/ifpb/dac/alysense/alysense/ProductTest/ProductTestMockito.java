package br.edu.ifpb.dac.alysense.alysense.ProductTest;



@TestMethodOrder(Random.class)
public class ProductTestMockito{
 /*   Product product = mock(Product.class);

    Characteristic chara = mock(Characteristic.class);

    @Test
    public void mockProductName(){
        when(product.getName()).thenReturn("bolo");
        assertNotNull(product.getName());

        when(product.getName()).thenReturn("   ");
        assertTrue(product.getName().contains(" "));

        when(product.getName()).thenReturn("");
        assertNull(product.getName());

        verifyZeroInteractions(product.getName());
    }

    @Test
    public void mockProductCharacteristics(){
        List<Characteristic> mocked = mock(List<Characteristic>.class);
        List<Characteristic> spy = Mockito.spy();
    }

    @Test
    public void mockExceptiontest(){
        when(product.getId()).thenThrow(new NullPointerException());
        when(product.getName()).thenThrow(new NullPointerException());
        when(product.getCharacteristics()).thenThrow(new NullPointerException());
        when(product.getOwner()).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> product.getName());
        assertThrows(NullPointerException.class, () ->product.getId());
        assertThrows(NullPointerException.class, ()-> product.getOwner());
        assertThrows(NullPointerException.class,()-> product.getCharacteristics());
    }
    */
}