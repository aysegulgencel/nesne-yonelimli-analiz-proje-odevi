public class EyleyiciX implements IEyleyici {

    @Override
    public int sogutucuAc(int sicaklik, String tur) throws InterruptedException {
        LogEkran.getInstance().log("Soğutucu Açılıyor... Sıcaklık Düşürülüyor...");
        Thread.sleep(1000);
        sicaklik -= 10;
        LogEkran.getInstance().log("Sıcaklık, " + (sicaklik + 10) + " " + tur + "'den " + sicaklik + " " + tur + "'e düşürüldü...");
        return sicaklik;
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        LogEkran.getInstance().log("Soğutucu Kapatılıyor...");
        Thread.sleep(1000);
        LogEkran.getInstance().log("Soğutucu Kapatıldı...");
    }

}
