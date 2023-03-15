import org.junit.Assert;
import org.junit.Test;

import static utilities.DatabaseUtilty.*;

//bu clasta junit kullandigimiz icin pom.cml dependency kismina junit kodalarini yapistirdik.
public class JUnit_Test {
    @Test
    public void test01() {
        createConnection(); //1. step: create connection with database
        String sql01 = "select * from ogrenciler"; //ogrenciler tablosunu al sql01 icine ata
        getColumnData(sql01, "ogrenci_ismi"); //ogrenci ismi sutununu al
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI", getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu"));

//2.yolda string mesaj yazmaz
//Assert.assertTrue(getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu") );

        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI", getColumnData(sql01, "ogrenci_ismi").contains("Ahmet Aslan"));
        closeConnection();//2. step: close connection with database
    }

    @Test
    public void test02() {
        createConnection();
Assert.assertTrue("DATABASE DE KAYIT BULUNAMADI",
        getColumnData("select * from ogrenciler","okul_no").contains(118));

        closeConnection();

    }
}
