public class EyleyiciY implements IEyleyici {

    @Override
    public int sogutucuAc(int sicaklik, String tur) throws InterruptedException {
        LogEkran.getInstance().log("Soğutucu Açılıyor... Sıcaklık Düşürülüyor...");
        Thread.sleep(2000);
        sicaklik -= 15;
        LogEkran.getInstance().log("Sıcaklık, " + (sicaklik + 15) + " " + tur + "'den " + sicaklik + " " + tur + "'e düşürüldü...");
        return sicaklik;
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        LogEkran.getInstance().log("Soğutucu Kapatılıyor...");
        Thread.sleep(2000);
        LogEkran.getInstance().log("Soğutucu Kapatıldı...");
    }
}
