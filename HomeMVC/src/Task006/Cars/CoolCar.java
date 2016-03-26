package Task006.Cars;

/**
 * Created by Рустам on 25.02.2016.
 */
public interface CoolCar extends Car, Signalable, Coldable {
    boolean isCold();
    boolean isHot();
    String getSignal();
}
