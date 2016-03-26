package Task006.Cars;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface Signalable {
    void signalTurn(boolean signalOn);
    void doSignal();
    void getRadar(double distanceToCar, double speedOfCar);
}
