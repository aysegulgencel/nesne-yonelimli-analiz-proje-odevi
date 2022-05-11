import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LogDosya implements ILogger {

    private static LogDosya instance;
    private PrintWriter out;

    private LogDosya() {
        try {
            out = new PrintWriter(new FileWriter("log.txt", true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized LogDosya getInstance() {
        if (instance == null)
            instance = new LogDosya();
        return instance;
    }

    @Override
    public void log(String mesaj) {
        out.println(LocalDateTime.now() + ":" + mesaj);
    }
}
