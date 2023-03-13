import java.sql.*;

public class Query01 {
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

        //4. adım result set
        ResultSet veri = st.executeQuery("select*from ogrenciler");  //database den alinan veri bu kaba koyuluyor.
        // bu kabı kullanacagiz.

        //5.adim datalari al
        while (veri.next()) {
            System.out.println(veri.getInt(1)
                    + veri.getString(2)
                    + veri.getString(3)
                    + veri.getString(4));
        }


        //6.adim baglantilari kapatma
        con.close();
        st.close();
        veri.close();
    }


}
