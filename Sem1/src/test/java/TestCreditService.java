import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.*;
import ru.kpfu.itis.khakov.repository.CarRepository;
import ru.kpfu.itis.khakov.repository.CreditRepository;
import ru.kpfu.itis.khakov.repository.StatusRepository;
import ru.kpfu.itis.khakov.service.CarService;
import ru.kpfu.itis.khakov.service.CreditService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestCreditService {
    private static CreditService creditService;
    private static Status status;
    private static List<Credit> credits;
    private static Credit credit;
    private static Car car;
    private static User user;


    @BeforeClass
    public static void init() {
        creditService = new CreditService();
        creditService.creditRepository = mock(CreditRepository.class);
        creditService.statusRepository = mock(StatusRepository.class);
        credit = new Credit();
        Credit credit1 = new Credit();
        status = mock(Status.class);
        car = mock(Car.class);
        user = mock(User.class);
        credit.setStatus(status);
        credit.setDate(mock(Date.class));
        credit.setName("alex");
        credit.setUser(user);
        credit.setCar(car);
        credit.setNumber("123");
        credit1 = credit;
        credit.setId(1L);
        credit1.setId(2L);
        credits = new ArrayList<Credit>();
        credits.add(credit);
        credits.add(credit1);
        when(creditService.creditRepository.findAll()).thenReturn(credits);
        when(creditService.creditRepository.findByStatus(any(Status.class))).thenReturn(credits);
        when(creditService.creditRepository.findByUser(any(User.class))).thenReturn(credits);
        when(creditService.statusRepository.findByStatus(anyString())).thenReturn(status);
        when(creditService.creditRepository.findById(anyLong())).thenReturn(credit);
        when(creditService.statusRepository.findById(anyLong())).thenReturn(status);
        when(creditService.creditRepository.saveAndFlush(any(Credit.class))).thenReturn(credit);
    }

    @Test
    public void getAllShouldReturnCorrectListOfCredit() {
        List<Credit> credits1 = creditService.getAll();
        Assert.assertEquals(credits1, credits);
    }
    @Test
    public void getByStatusShouldReturnCorrectListOfCredit() {
        List<Credit> credits1 = creditService.getByStatus(status);
        Assert.assertEquals(credits1, credits);
    }
    @Test
    public void getCreditByStatusShouldReturnCorrectListOfCredit() {
        List<Credit> credits1 = creditService.getCreditByStatus("status");
        Assert.assertEquals(credits1, credits);
    }
    @Test
    public void getCreditByUserShouldReturnCorrectListOfCredit() {
        List<Credit> credits1 = creditService.getByUser(user);
        Assert.assertEquals(credits1, credits);
    }
    @Test
    public void getByIdShouldReturnCorrectCredit() {
        Assert.assertEquals(creditService.getById(1L), credit);
    }

    @Test
    public void addCarShouldAddCar() {
        Assert.assertEquals(creditService.saveCredit(credit), credit);
    }
    @Test
    public void  changeStatusShouldReturnCorrectCar(){
        Car car1 = new Car();
        car1.setId(1L);
        Assert.assertEquals(creditService.changeStatus(1L,1L), credit);
    }
}
