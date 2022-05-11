import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
        IMerkeziIslemBirimiGiris giris = new MerkeziIslemBirimiGiris();

        String kullaniciAdi, sifre;

        /* Durum,
            1 ise -> Cihaz Kapalı (cihaz aç)
            2 ise -> Cihaz Beklemede(soğutucu aç, kapat, sıcaklık oku)
            3 ise -> Cihaz Algılama modunda (sıcaklık oku)
            4 ise -> Cihazın soğutucuyu açıp kapatması esnasındaki durum
         */
        int durum = 1; // Cihaz kapalı olarak başlar
        boolean sogutucuDurumu = false;

        System.out.println("**Kullanıcı Adınızı Giriniz**");
        kullaniciAdi = scan.nextLine();

        System.out.println("**Şifrenizi Giriniz**");
        sifre = scan.nextLine();

        if (giris.girisYap(kullaniciAdi, sifre)) {

            if (durum == 1) {
                int secim = 0;
                do {
                    System.out.println("**Cihazı açmak için 1'e basınız**");
                    secim = scan.nextInt();
                } while (secim != 1);
                durum = 3;
            }
            IMerkeziIslemBirimiCihaz islemci = new MerkeziIslemBirimiCihaz(); // Cihaz çalıştırılır

            if (durum == 3) {
                int secim = 0;
                do {
                    System.out.println("**Sıcaklığı okumak için 1'e basınız**");
                    secim = scan.nextInt();
                } while (secim != 1);
                islemci.sicaklikOku(); // Sıcaklık okunur
                durum = 2;
            }


            if (durum == 2) {

                int secim;
                do {
                    if (!sogutucuDurumu) // Soğutucu kapalıysa açma seçeneğinin arayüzde görüntülenmesi sağlanır
                        System.out.println("1-Soğutucuyu Aç");
                    else // Soğutucu açıksa kapatma seçeneğinin arayüzde görüntülenmesi sağlanır
                        System.out.println("2-Soğutucuyu Kapat");

                    System.out.println("3-Çıkış Yap");
                    secim = scan.nextInt();

                    if (secim == 1 && !sogutucuDurumu) { // Soğutucu kapalıysa ve açma seçeneği seçildiyse soğutucu açılır
                        islemci.sogutucuAc();
                        sogutucuDurumu = true;
                    } else if (secim == 2 && sogutucuDurumu) { // Soğutucu açıksa ve kapatma seçeneği seçildiyse soğutucu kapatılır
                        islemci.sogutucuKapat();
                        sogutucuDurumu = false;
                    } else if (secim == 3) {
                        LogEkran.getInstance().log("Çıkış Yapılıyor...");
                        Thread.sleep(1000);
                        LogEkran.getInstance().log("Cihaz Kapatılıyor");
                    } else {
                        System.out.println("**Lütfen Geçerli Bir Seçenek Giriniz**");
                    }

                } while (secim != 3);
            }

        }

	}

}
