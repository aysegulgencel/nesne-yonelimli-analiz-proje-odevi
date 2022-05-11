import java.sql.*;

public class VeritabaniIslemleri implements IVeritabaniIslemleri {
	
	@Override
	public void migrate(Connection conn) { // user tablosu olustur.
		boolean isAlreadyExist = false;
        try {
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery("create table users(id serial primary key, username varchar(50), paayssword varchar(50))");
        }
        catch (Exception e) {}
	}

    private Connection baglan() throws SQLException {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ay",
                    "postgres", "16281628aG");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.migrate(conn);
        return conn;
    }

    @Override
    public boolean girisYap(String k_adi, String pass) { // Başarılı bir şekilde giriş yapılıp yapılmadığını döndürür
        try {
            boolean girisDurumu;

            Connection conn = this.baglan(); // Veritabanı bağlantısı yapılır

            // Konsoldan girilen bilgilere uygun kişiyi veritabanından seçmek için gerekli SQL sorgusu yazılır
            String sql = "SELECT *  FROM \"users\" WHERE \"username\"='" + k_adi + "' and \"password\"='" + pass + "'";

            // Sorgu çalıştırılır
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Veritabanı bağlantısı sonlandırılır
            conn.close();

            Thread.sleep(500);
            if (!rs.next()) { // Veritabanından dönen ResultSet boş ise böyle bir kullanıcı yoktur
                System.out.println("Böyle bir kullanıcı bulunamadı...");
                girisDurumu = false;
            } else { // ResultSet boş değilse giriş başarılıdır
                System.out.println("Giriş başarılı...");

                // Oturum, kullanıcı bilgileriyle birlikte dosyaya loglanır
                LogDosya.getInstance().log("Yeni Oturum... Kullanıcı Bilgileri: Id: " + rs.getInt("Id")
                        + " userName: " + rs.getString("userName"));
                girisDurumu = true;
            }

            /***** Kaynakları serbest bırak *****/
            rs.close();
            stmt.close();
            return girisDurumu;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
