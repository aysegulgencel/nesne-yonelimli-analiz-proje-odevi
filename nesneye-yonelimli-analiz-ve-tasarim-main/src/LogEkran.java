import java.time.LocalDateTime;

public class LogEkran implements ILogger {
    private static LogEkran instance;

    private LogEkran() { }

    public static synchronized ILogger getInstance() {
        if (instance == null)
            instance = new LogEkran();
        return instance;
    }

    @Override
    public void log(String mesaj) {
            System.out.println(LocalDateTime.now() + ": " + mesaj);
            LogDosya.getInstance().log(mesaj);
    }
}
