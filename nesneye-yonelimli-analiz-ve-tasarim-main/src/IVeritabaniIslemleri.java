import java.sql.Connection;

public interface IVeritabaniIslemleri {
	void migrate(Connection C);
    boolean girisYap(String k_adi, String pass);
}
