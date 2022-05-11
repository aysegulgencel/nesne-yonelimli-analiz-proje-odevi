public class KritikSogutma implements IObserver {

    @Override
    public int kritikDurum(int kritikSicaklik, IEyleyici eyleyici, String tur) throws InterruptedException {
        LogEkran.getInstance().log("Kritik Soğutma Devreye Giriyor...");
        Thread.sleep(500);
        return eyleyici.sogutucuAc(kritikSicaklik, tur);
    }

}
