package Task004;

import Task004.GearBox.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Рустам on 25.02.2016.
 */
public class TestMechanicGearBox {
    public static GearBox gearBox;

    @Test
    public void nextGearShouldBeCorrect(){
        gearBox = new MechanicGearBox();
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
