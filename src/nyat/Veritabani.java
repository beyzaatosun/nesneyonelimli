package nyat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Veritabani {

    private static Veritabani instance = null;
    private synchronized static void createInstance() {
        if (instance == null)
            instance = new Veritabani();
    }
    public static Veritabani getInstance() {
        if (instance == null)
            createInstance();
        return instance;
    }

    private Connection Baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kullanıcı",
                    "postgres", "123698");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean Kontrol(String KullaniciAdi , String Sifre)
    {
        String sql= "SELECT * FROM \"public\".\"kullanıcılar\"";
        String isim = "";
        String sifre = "";

        Connection conn=this.Baglan();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            while(rs.next())
            {
                isim = rs.getString("ad");
                sifre = rs.getString("sifre");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isim.equals(KullaniciAdi) && sifre.equals(Sifre);

    }
}