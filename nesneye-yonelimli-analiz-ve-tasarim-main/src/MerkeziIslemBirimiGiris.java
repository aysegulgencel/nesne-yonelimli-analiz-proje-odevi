
public class MerkeziIslemBirimiGiris implements IMerkeziIslemBirimiGiris {

    private final IVeritabaniIslemleri veritabani;

    public MerkeziIslemBirimiGiris() throws InterruptedException {
        this.veritabani = new VeritabaniIslemleri();
    }

    @Override
    public boolean girisYap(String userName, String password) throws InterruptedException {
        Thread.sleep(1500);
        if (this.veritabani.girisYap(userName, password)) {
            return true;
        } else {
            return false;
        }
    }
}
