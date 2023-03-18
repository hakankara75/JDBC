import java.sql.*;

public class Query04 {
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

        //4.adım verileri detayli gormek istiyorus RSMD olustururuz
        ResultSet rs=st.executeQuery("select * from ogrenciler");
        ResultSetMetaData rsmd=rs.getMetaData();

        System.out.println("Sutun sayisi : "+rsmd.getColumnCount());
        System.out.println("1. sutunun ismi : "+rsmd.getColumnName(1));
        System.out.println("Tablo ismi: "+rsmd.getTableName(1));
        System.out.println("Sutun data tipi: "+rsmd.getColumnTypeName(1));
        con.close();
        st.close();
        rs.close();

    }
}