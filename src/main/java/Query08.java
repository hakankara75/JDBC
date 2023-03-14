import static utilities.DatabaseUtilty.*;

public class Query08 {
    public static void main(String[] args) {
        createConnection(); //utilities den metot cagirarak baglanti, dosyayi okuma, ekleme vb. yapiyoruz.
        String sql01 = "select * from ogrenciler";
        System.out.println("Sutun isimleri " + getColumnNames(sql01));
        System.out.println("Okul numaralari: " + getColumnData(sql01, "okul_no"));
        System.out.println("Ogrenci isimleri: " + getColumnData(sql01, "ogrenci_ismi"));
        System.out.println("Ogrenci sinifi: " + getColumnData(sql01, "sinif"));


    }
}
