import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.*;
import ru.kpfu.itis.khakov.repository.CreditRepository;
import ru.kpfu.itis.khakov.repository.MyCarRepository;
import ru.kpfu.itis.khakov.repository.StatusRepository;
import ru.kpfu.itis.khakov.service.CreditService;
import ru.kpfu.itis.khakov.service.MyCarService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestMyCarService {
    private static MyCarService myCarService;
    private static List<MyCar> myCars;
    private static List<Attribute> attributes;
    private static MyCar myCar;
    private static Car car;
    private static User user;


    @BeforeClass
    public static void init() {
        myCarService = new MyCarService();
        myCarService.myCarRepository = mock(MyCarRepository.class);
        myCar = new MyCar();
        attributes = new ArrayList<Attribute>();
        attributes.add(mock(Attribute.class));
        car = mock(Car.class);
        user = mock(User.class);
        myCar.setStatus(true);
        myCar.setDate(mock(Date.class));
        myCar.setColor(mock(Color.class));
        myCar.setUser(user);
        myCar.setCar(car);
        myCar.setAttributes(attributes);
        MyCar myCar1 = myCar;
        myCar.setId(1L);
        myCar1.setId(2L);
        myCars = new ArrayList<MyCar>();
        myCars.add(myCar);
        myCars.add(myCar1);
        when(myCarService.myCarRepository.findAll()).thenReturn(myCars);
        when(myCarService.myCarRepository.findByStatus(anyBoolean())).thenReturn(myCars);
        when(myCarService.myCarRepository.findAllByDate(any(Date.class))).thenReturn(myCars);
        when(myCarService.myCarRepository.findAllByUser(any(User.class))).thenReturn(myCars);
        when(myCarService.myCarRepository.findById(anyLong())).thenReturn(myCar);
        when(myCarService.myCarRepository.saveAndFlush(any(MyCar.class))).thenReturn(myCar);
    }

    @Test
    public void getAllShouldReturnCorrectListOfMyCars() {
        List<MyCar> myCars1 = myCarService.getAll();
        Assert.assertEquals(myCars1, myCars);
    }
    @Test
    public void getAllByUserShouldReturnCorrectListOfMyCars() {
        List<MyCar> myCars1 = myCarService.getByUser(user);
        Assert.assertEquals(myCars1, myCars);
    }
    @Test
    public void getAllByStatusShouldReturnCorrectListOfMyCars() {
        List<MyCar> myCars1 = myCarService.getByStatus(true);
        Assert.assertEquals(myCars1, myCars);
    }

    @Test
    public void getByIdShouldReturnCorrectListOfMyCars() {
        MyCar myCar1 = myCarService.getById(1L);
        Assert.assertEquals(myCar1, myCar);
    }
    @Test
    public void saveCarShouldReturnCorrectListOfMyCars() {
        MyCar myCar1 = myCarService.saveCar(myCar, attributes);
        Assert.assertEquals(myCar1, myCar);
    }
    @Test
    public void changeCarShouldReturnCorrectListOfMyCars() {
        MyCar myCar1 = myCarService.changeCar(1L,"0");
        Assert.assertEquals(myCar1, myCar);
    }
}

