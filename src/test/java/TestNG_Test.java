    //bu clasta ng kullandigimiz icin pom.cml dependency kismina ng kodalarini yapistirdik.
    import org.testng.Assert;
    import org.testng.annotations.Test;
    import static utilities.DatabaseUtilty.*;

    public class TestNG_Test {

        @Test
        public void test01(){
            createConnection();
            String sql01="select * from ogrenciler";
            Assert.assertTrue(getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu"),
                    "DATABASE'DE KAYIT BULUNAMADI");
            closeConnection();
        }//test01 son satırı

        @Test
        public void test02(){
            createConnection();
            Assert.assertTrue(getColumnData("select * from ogrenciler", "okul_no").contains(120),
                    "DATABASE'DE KAYIT BULUNAMADI");

            closeConnection();
        }
    }