import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SicaklikAlgilayiciCelsius implements ISicaklikAlgilayici {
    private final String tur = "°C";
    private final int kritikSicaklik = 40;

    @Override
    public List<Serializable> sicaklikOku() throws InterruptedException {
        LogEkran.getInstance().log("Sıcaklık Okunuyor...");
        Random rand = new Random();
        int randomValue = rand.nextInt(60);
        Thread.sleep(1000);
        LogEkran.getInstance().log("Sıcaklık: " + randomValue + "°C");
        return Arrays.asList(randomValue, this.kritikSicaklik, this.tur);
    }
}