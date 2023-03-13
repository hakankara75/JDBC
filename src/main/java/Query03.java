import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query03 {

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

    //4.steps
//"workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.
String sql01="Create Table workers (worker_id varchar (10), worker_name varchar (20), worker_salary int)";
st.execute(sql01);

//5.steps
//Table'a worker_address sütunu ekleyin.
String sql02="Alter table workers add worker_address varchar (50)";
st.execute(sql02);

//6.steps
// workers table'ını silin.
String sql03= "drop table workers";
st.execute(sql03);
}
}
//execute() --> create, drop, alter table (DDL) icin kullanilir.
//executeQuery() --> sorgulama yapar ve sonucu bir kutuya atama yapar.