package Task007;

import Task006.Cars.*;
import Task006.GearBox.GearBox;
import Task006.GearBox.MechanicGearBox;
import Task006.GearBox.RobotGearBox;
import Task006.MotorType.DieselMotor;
import Task006.MotorType.ElectricMotor;
import Task006.MotorType.Motor;
import Task006.MotorType.PetrolMotor;
import Task006.Wheels.SummerWheel;
import Task006.Wheels.Wheel;
import Task006.Wheels.WinterWheel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Rus on 02.03.2016.
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        CoolCar audi = ac.getBean(AudiQ7.class);
        CoolCar bmw = ac.getBean(BmwX5.class);
        Car lada= ac.getBean(Lada2101.class);
        Car renault = ac.getBean(RenaultClio.class);
        Car smartCar = ac.getBean(SmartCar.class);
        Wheel winterWheel = (WinterWheel) ac.getBean("winterWheel");
        Wheel summerWheel = (SummerWheel) ac.getBean("summerWheel");
        Motor dieselMotor = (DieselMotor) ac.getBean("dieselMotor");
        Motor electricMotor = (ElectricMotor) ac.getBean("electricMotor");
        Motor petrolMotor = (PetrolMotor) ac.getBean("petrolMotor");
        GearBox mechanicGearBox = (MechanicGearBox) ac.getBean("mechanicGearBox");
        GearBox robotGearBox = (RobotGearBox) ac.getBean("robotGearBox");
        winterWheel.inflatedWheel(0.5);
        winterWheel.protectorDecrease(4);
        summerWheel.inflatedWheel(0.6);
        summerWheel.protectorDecrease(4);
        System.out.println(winterWheel.getTypeOfWheel()+ " : " + winterWheel.getProtectorHight());
        bmw.turnOnMotor();
        bmw.setNewWheel(winterWheel);
        bmw.setNewWheel(summerWheel);
        bmw.signalTurn(true);
        bmw.doSignal();
        bmw.hotAirOn();
        bmw.hotAirOff();
        audi.doMove();
        audi.doSignal();
        audi.coldAirOn();
        audi.coldAirOff();
        smartCar.doMove();
        renault.turnOnMotor();
        renault.turnOffMotor();
        System.out.println(renault.getTypeOfCar());
        System.out.println("Max Horsepower: " + lada.getMaxSpeed(dieselMotor, robotGearBox));
        System.out.println("Acceleration: " + lada.getAcceleration(electricMotor, mechanicGearBox));
        audi.setNewMotor(dieselMotor);
        System.out.println(audi.getTypeOfTurn()+ " " + audi.getTypeOfCar());
//        Institute i = (Institute) ac.getBean("itInstitute");
//        System.out.println(i);
//        Univer u = ac.getBean(Univer.class);
//        System.out.println(u);
//        Student s = ac.getBean(Student.class);
//        System.out.println(s);
    }
}
