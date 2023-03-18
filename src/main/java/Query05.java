import java.sql.*;

public class Query05 {
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
//SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K')
st.executeUpdate("insert into ogrenciler values (300, 'Sena Can', 12, 'K')");

//int a=st.executeUpdate("insert into ogrenciler values (300, 'Sena Can', 12, 'K')");
       // System.out.println(a+" satir database eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
// (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')
   String []veri= {"insert into ogrenciler values (400, 'Sena Can', 12, 'K')",
              "insert into ogrenciler values (401, 'Sena Can', 12, 'K')",
              "insert into ogrenciler values (402, 'Sena Can', 12, 'K')"};
      int count=0;
      for (String each: veri){
          st.executeUpdate(each); //loop dondukce her seferinde data gonderir, ekler.
          count++;

      }
        System.out.println(count+ " adet satir eklendi");

      //2.yol
        String []veri1= {"insert into ogrenciler values (700, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (701, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (702, 'Sena Can', 12, 'K')"};
        for (String each:veri1){
            st.addBatch(each); //datalari loop icinde bir araya getirir, tek seferde gonderir, ekler.
        }
        st.executeBatch();
        con.close();
        st.close();

}


}
