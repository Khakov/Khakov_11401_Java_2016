package Task010;

import Task006.GearBox.GearBox;
import Task006.GearBox.MechanicGearBox;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestMechanicGearBox {
    public static GearBox gearBox;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");


    @Test
    public void nextGearShouldBeCorrect(){
        gearBox = (MechanicGearBox) ac.getBean("mechanicGearBox");
        Assert.assertEquals(1,gearBox.nextGear());
        Assert.assertEquals(99999, gearBox.getGearLife());
    }
    @Test
    public void lastGearShouldBeCorrect(){
        gearBox = new MechanicGearBox();
        Assert.assertEquals(-1,gearBox.lastGear());
        Assert.assertEquals(99999, gearBox.getGearLife());
    }
    @Test
    public void rearGearShouldBeCorrect(){
        gearBox = new MechanicGearBox();
        Assert.assertEquals(-1,gearBox.onRearGear());
        Assert.assertEquals(99999, gearBox.getGearLife());
    }
}
