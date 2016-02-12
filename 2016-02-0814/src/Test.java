import Cars.*;
import Wheels.Wheel;
import Wheels.WinterWheel;

/**
 * Created by Рустам on 12.02.2016.
 */
public class Test {
    public static void main(String[] args) {
        Wheel wheel = new WinterWheel();
        BmwX5 BmwX5 = new BmwX5();
        AudiQ7 AudiQ7 = new AudiQ7();
        System.out.println(BmwX5.turnOnMotor());
        BmwX5.setNewWheel(wheel);
        AudiQ7.doMove();
        System.out.println(BmwX5.doSignal());
        AudiQ7.doSignal();
        AudiQ7.doSignal();
        Car smartCar = new SmartCar();//восходящее преобразование
        Car renaultClio = new RenaultClio();
        System.out.println(smartCar.doMove());
        System.out.println(renaultClio.turnOnMotor());// позднее связывание
        System.out.println(renaultClio.turnOffMotor());
        System.out.println(renaultClio.getTypeOfCar());

    }
}
