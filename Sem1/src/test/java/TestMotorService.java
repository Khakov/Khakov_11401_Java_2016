import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Motor;
import ru.kpfu.itis.khakov.repository.MotorRepository;
import ru.kpfu.itis.khakov.service.MotorService;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestMotorService {
    private static MotorService motorService;
    private static Motor motor;


    @BeforeClass
    public static void init() {
        motorService = new MotorService();
        motorService.repository = mock(MotorRepository.class);
        motor = new Motor();
        motor.setType("type");
        motor.setConsumption(12);
        motor.setHorsepower(123);
        motor.setId(1L);
        when(motorService.repository.findById(anyLong())).thenReturn(motor);
    }

    @Test
    public void getByIdShouldReturnCorrectColor() {
        Assert.assertEquals(motorService.getMotor(), motor);
    }

}
