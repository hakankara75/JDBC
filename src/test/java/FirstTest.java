
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue; //static olunca asagida Assert kullanmak zorunda kalmayiz.

import org.junit.Test;
import utilities.utilities.DatabaseUtilty;

public class FirstTest {
    @Test
    public void firstTest01(){
        assertTrue(4<5); //dogrulama kodu.
        assertTrue(6<5); //test hata verir. cunku false


    }

    @Test
    public void firstTest02(){
        assertTrue("Test Fail ", 5<4); //false ise metot icindeki string yazilir.
    }

    @Test
    public void firstTest03(){
assertEquals("Sayilar esit degi", "3", "3"); //false ise string mesaji yazdirir.
assertEquals("Sayilar esit degi", "3", "6"); //false ise string mesaji yazdirir.
    }


}
