import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. adim Driver Tanimla
        Class.forName("org.postgresql.Driver");

        //2.adim Database'e baglanma
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "533burak");
        //3. statement
    Statement st = con.createStatement();

// SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)
//st.execute("create table urunler(id int, isim varchar(10), fiyat int)");


//cok miktarda kayit eklemek icin PreparedStatement metodu kullanilir. Bunun haricinde pojo class kullanilir.
        List<Urun>kayitlar=new ArrayList<>();

        kayitlar.add(new Urun(100, "Laptop", 35000));
        kayitlar.add(new Urun(101, "Mause", 745));
        kayitlar.add(new Urun(102, "LCD Tv", 40000));
        kayitlar.add(new Urun(103, "MacBook", 45000));
        kayitlar.add(new Urun(104, "Tablet", 11900));
        kayitlar.add(new Urun(105, "Anakart", 6550));

        PreparedStatement tablo= con.prepareStatement("insert into urunler values (?,?,?)");

        for (Urun each: kayitlar){
            tablo.setInt(1, each.getId());
            tablo.setString(2, each.getIsim());
            tablo.setDouble(3, each.getFiyat());

            tablo.addBatch();//tüm veriler birlesiyor bu komutla
        }
        tablo.executeBatch();  //tüm veriler tek seferde beraber gidiyor bu komutla
    }
}
