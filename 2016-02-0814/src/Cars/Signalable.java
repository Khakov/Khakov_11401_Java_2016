package Cars;

/**
 * Created by Рустам on 12.02.2016.
 */
public interface Signalable {
    void signalTurn(boolean signalOn);
    String doSignal();
    String getRadar(double distanceToCar, double speedOfCar);
}
