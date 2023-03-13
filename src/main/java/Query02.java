import java.sql.*;

public class Query02 {
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

        //SORU: region id si 1 olan country name degerlerini cagirin.
        String sql01= "select country_name from countries where region_id=1";

        //4. adım result set
        ResultSet veri = st.executeQuery(sql01);  //database den alinan veri bu kaba koyuluyor.
        // bu kabı kullanacagiz.
        while (veri.next()) {
            System.out.println(veri.getString(1));//sorguda region_id=1 oldugu icin tek sutun secildi.
        }
        System.out.println();
//Soru: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.
        String sql02="select country_id, country_name from countries where region_id>2";
        ResultSet veri1 = st.executeQuery(sql02);
        while (veri1.next()) {
            System.out.println(veri1.getString(1)+
                    veri1.getString(2));//sorguda region_id=1 oldugu icin tek sutun secildi.
     //       System.out.println(veri1.getString("country_id"+ " " +"country_name"));   bu da olur.

        }
        con.close();
        st.close();
        veri1.close();
        veri.close();
    }
    }

