
public class ProductTestMockito{

    @mock
    Produtct product 

@Test(expected = NullpointException.class)
public void mockExceptiontest(){
    when(product.getId()).themThrow(new NullpointException())
    when(product.getName()).themThrow(new NullpointException())
    when(product.getCharacteristic()).themThrow(new NullpointException())
    when(product.getOwner).themThrow(new NullpointException())

    assertAll(() -> assertThrows(NullpointException.class, () -> product.getName()), () -> assertThrows(NullpointException.class, () ->product.getId()),
    assertThrows(NullpointException.class, ()-> product.getOwner()), assertThrows(NullpointException.class,()-> product.getCharacteristic()));
}
}