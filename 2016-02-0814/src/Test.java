import Cars.*;
import GearBox.RobotGearBox;
import MotorType.DieselMotor;
import Wheels.SummerWheel;
import Wheels.Wheel;
import Wheels.WinterWheel;

/**
 * Created by Рустам on 12.02.2016.
 */
public class Test {
    public static void main(String[] args) {
        Wheel WinterWheel = new WinterWheel();
        Wheel SummerWheel = new SummerWheel();
        WinterWheel.inflatedWheel(0.5);
        WinterWheel.protectorDecrease(4);
        SummerWheel.inflatedWheel(0.6);
        SummerWheel.protectorDecrease(4);
        System.out.println(WinterWheel.getTypeOfWheel()+ " : " + WinterWheel.getProtectorHight());
        BmwX5 BmwX5 = new BmwX5();
        BmwX5.turnOnMotor();
        BmwX5.setNewWheel(WinterWheel);
        BmwX5.setNewWheel(SummerWheel);
        BmwX5.signalTurn(true);
        BmwX5.doSignal();
        BmwX5.HotAirOn();
        BmwX5.HotAirOff();
        AudiQ7 AudiQ7 = new AudiQ7();
        AudiQ7.doMove();
        AudiQ7.doSignal();
        AudiQ7.ColdAirOn();
        AudiQ7.ColdAirOff();
        System.out.println("Max Horsepower: " + AudiQ7.getMaxSpeed(new DieselMotor(), new RobotGearBox()));
        System.out.println("Acceleration: " + AudiQ7.getAcceleration(new DieselMotor(), new RobotGearBox()));
        AudiQ7.setNewMotor(new DieselMotor());
        System.out.println(AudiQ7.getTypeOfTurn()+ " " + AudiQ7.getTypeOfCar());

        Car smartCar = new SmartCar();//восходящее преобразование
        Car renaultClio = new RenaultClio();
        smartCar.doMove();
        renaultClio.turnOnMotor();// позднее связывание
        renaultClio.turnOffMotor();
        System.out.println(renaultClio.getTypeOfCar());
    }
}
