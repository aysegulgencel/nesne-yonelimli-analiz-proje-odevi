
public interface IObserver {
    int kritikDurum(int kritikSicaklik, IEyleyici eyleyici, String tur) throws InterruptedException;
}
