import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.entity.Status;
import ru.kpfu.itis.khakov.entity.TestDrive;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.StatusRepository;
import ru.kpfu.itis.khakov.repository.TestDriveRepository;
import ru.kpfu.itis.khakov.service.TestDriveService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 12.05.2016.
 */
public class TestTestDriveService {
    private static TestDriveService testDriveService;
    private static Status status;
    private static List<TestDrive> testDrives;
    private static TestDrive testDrive;
    private static Car car;
    private static User user;


    @BeforeClass
    public static void init() {
        testDriveService = new TestDriveService();
        testDriveService.testDriveRepository = mock(TestDriveRepository.class);
        testDriveService.statusRepository = mock(StatusRepository.class);
        testDrive = new TestDrive();
        TestDrive testDrive1 = new TestDrive();
        status = new Status();
        status.setStatus("готово");
        car = mock(Car.class);
        user = mock(User.class);
        testDrive.setStatus(status);
        testDrive.setDate("01.01.2016");
        testDrive.setName("alex");
        testDrive.setUser(user);
        testDrive.setCar(car);
        testDrive.setNumber("123");
        testDrive1 = testDrive;
        testDrive.setId(1L);
        testDrive1.setId(2L);
        testDrives = new ArrayList<TestDrive>();
        testDrives.add(testDrive);
        testDrives.add(testDrive1);
        when(testDriveService.testDriveRepository.findAll()).thenReturn(testDrives);
        when(testDriveService.testDriveRepository.findByStatus(any(Status.class))).thenReturn(testDrives);
        when(testDriveService.testDriveRepository.findByUser(any(User.class))).thenReturn(testDrives);
        when(testDriveService.statusRepository.findByStatus(anyString())).thenReturn(status);
        when(testDriveService.testDriveRepository.findById(anyLong())).thenReturn(testDrive);
        when(testDriveService.statusRepository.findById(anyLong())).thenReturn(status);
        when(testDriveService.testDriveRepository.saveAndFlush(any(TestDrive.class))).thenReturn(testDrive);
    }

    @Test
    public void getByUserShouldReturnCorrectListOfTestDrive() {
        List<TestDrive> credits1 = testDriveService.getByUser(user);
        Assert.assertEquals(credits1, testDrives);
    }
    @Test
    public void getByStatusShouldReturnCorrectListOfTestDrive() {
        List<TestDrive> credits1 = testDriveService.getByStatus("готово");
        Assert.assertEquals(credits1, testDrives);
    }
    @Test
    public void getByIdShouldReturnCorrectCredit() {
        Assert.assertEquals(testDriveService.getById(1L), testDrive);
    }

    @Test
    public void addCarShouldAddCar() {
        Assert.assertEquals(testDriveService.saveTestDrive(testDrive), testDrive);
    }
    @Test
    public void  changeStatusShouldReturnCorrectTestDrive(){
        TestDrive testDrive1 = new TestDrive();
        testDrive1.setId(1L);
        Assert.assertEquals(testDriveService.changeStatus(1L,1L, "01.01.2016"), testDrive);
    }
}
