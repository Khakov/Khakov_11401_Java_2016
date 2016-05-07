import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.*;
import ru.kpfu.itis.khakov.repository.MyCarRepository;
import ru.kpfu.itis.khakov.repository.RemontRepository;
import ru.kpfu.itis.khakov.repository.ResultRepository;
import ru.kpfu.itis.khakov.service.MyCarService;
import ru.kpfu.itis.khakov.service.RemontService;
import ru.kpfu.itis.khakov.service.ResultService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestRemontService {
    private static RemontService remontService;
    private static List<Remont> remonts;
    private static Remont remont;
    private static User user;
    private static Car car;
    private static Type type;
    private static Result result;


    @BeforeClass
    public static void init() {
        remontService = new RemontService();
        remontService.remontRepository = mock(RemontRepository.class);
        remontService.resultRepository = mock(ResultRepository.class);
        remonts = new ArrayList<Remont>();
        user = mock(User.class);
        car = mock(Car.class);
        remont= new Remont();
        remont.setCar(car);
        result = mock(Result.class);
        remont.setDate(mock(Date.class));
        remont.setDescription("description");
        remont.setUser(user);
        remont.setName("name");
        remont.setNumber("132");
        remont.setType(type);
        remont.setResult(result);
        Remont remont1 = remont;
        remont.setId(1L);
        remont1.setId(2L);
        remonts.add(remont);
        remonts.add(remont1);
        when(remontService.remontRepository.findAll()).thenReturn(remonts);
        when(remontService.remontRepository.findByResult(any(Result.class))).thenReturn(remonts);
        when(remontService.remontRepository.findByUser(any(User.class))).thenReturn(remonts);
        when(remontService.remontRepository.findById(anyLong())).thenReturn(remont);
        when(remontService.remontRepository.saveAndFlush(any(Remont.class))).thenReturn(remont);
        when(remontService.resultRepository.findById(anyLong())).thenReturn(result);
        when(remontService.resultRepository.findByResult(anyString())).thenReturn(result);

    }

    @Test
    public void getAllShouldReturnCorrectListOfRemonts() {
        List<Remont> remonts1 = remontService.getAll();
        Assert.assertEquals(remonts1, remonts);
    }

    @Test
    public void getByResultShouldReturnCorrectListOfRemonts() {
        List<Remont> remonts1 = remontService.getByResult("result");
        Assert.assertEquals(remonts1, remonts);
    }

    @Test
    public void findByUserShouldReturnCorrectListOfRemonts() {
        List<Remont> remonts1 = remontService.findByUser(user);
        Assert.assertEquals(remonts1, remonts);
    }

    @Test
    public void saveShouldReturnCorrectRemonts() {
        Remont remont1 = remontService.saveRemont(remont);
        Assert.assertEquals(remont1, remont);
    }

    @Test
    public void changeShouldReturnCorrectRemonts() {
        Remont remont1 = remontService.changeResult(1L, 1L);
        Assert.assertEquals(remont1, remont);
    }

    @Test
    public void getByIdReturnCorrectRemonts() {
        Remont remont1 = remontService.getById(1L);
        Assert.assertEquals(remont1, remont);
    }
}
