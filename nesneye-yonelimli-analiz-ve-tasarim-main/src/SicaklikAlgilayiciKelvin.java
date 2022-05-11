import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SicaklikAlgilayiciKelvin implements ISicaklikAlgilayici {
    private final String tur = "°K";
    private final int kritikSicaklik = 313;

    @Override
    public List<Serializable> sicaklikOku() throws InterruptedException {
        LogEkran.getInstance().log("Sıcaklık Okunuyor...");
        Random rand = new Random();
        int randomValue = rand.nextInt(60) + 273;
        Thread.sleep(1000);
        LogEkran.getInstance().log("Sıcaklık: " + randomValue + "°K");
        return Arrays.asList(randomValue, this.kritikSicaklik, this.tur);
    }
}