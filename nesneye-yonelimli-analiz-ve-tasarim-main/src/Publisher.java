import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject {

    private final List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public int kritikSicaklikBildir(String mesaj, int kritikSicaklik, IEyleyici eyleyici, String tur) throws InterruptedException {
        LogEkran.getInstance().log(mesaj);
        for (IObserver subscriber : subscribers) {
            kritikSicaklik = subscriber.kritikDurum(kritikSicaklik, eyleyici, tur);
        }
        return kritikSicaklik;
    }
}
