import java.sql.*;

public class Query06 {
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
    st.executeUpdate("insert into ogrenciler values (800, 'Ali Can' , 11, 'E')");
        PreparedStatement ps= con.prepareStatement("insert into ogrenciler values (?, ? , ?, ?)"); // datalarin
        //giris formatini belirtiyorum.
/* Aynı SQL kodlarını kullacaksak statement değil preparedstatement kullanırız.
   Statament kullandığımızda her seferin kodu database iletir
   PraperedStatement kullandığımızda örneği saklar sadece dataları  iletir,

 */

        ps.setInt(1, 871); //1 rakami yukaridaki formattaki sirayi ifade eder.
        ps.setString(2,"Ali Can"); //2 rakami yukaridaki formattaki sirayi ifade eder.
        ps.setInt(3, 11); //3 rakami yukaridaki formattaki sirayi ifade eder.
        ps.setString(4,"E"); //4 rakami yukaridaki formattaki sirayi ifade eder.
        ps.executeUpdate();

        st.close();
        ps.close();
        con.close();
}
}
