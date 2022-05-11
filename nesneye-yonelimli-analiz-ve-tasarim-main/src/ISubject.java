
public interface ISubject {
    void attach(IObserver obs);

    void detach(IObserver obs);

    int kritikSicaklikBildir(String message, int kritikSicaklik, IEyleyici eyleyici, String tur) throws InterruptedException;
}
