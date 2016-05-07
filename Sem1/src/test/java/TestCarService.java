import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.entity.CarManufacture;
import ru.kpfu.itis.khakov.entity.Model;
import ru.kpfu.itis.khakov.repository.CarRepository;
import ru.kpfu.itis.khakov.service.CarService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestCarService {
    private static CarService carService;
    private static Model model;
    private static CarManufacture manufacture;
    private static List<Car> cars;
    private static Car car;


    @BeforeClass
    public static void init() {
        carService = new CarService();
        carService.carRepository = mock(CarRepository.class);
        car = new Car();
        Car car1 = new Car();
        model = mock(Model.class);
        manufacture = mock(CarManufacture.class);
        car.setPrice(1000000);
        car.setKof(1.0);
        car.setModel(model);
        car.setManufacture(manufacture);
        car1.setPrice(2000000);
        car1.setKof(1.2);
        car.setId(1L);
        car1.setManufacture(manufacture);
        car1.setModel(model);
        car1.setId(2L);
        cars = new ArrayList<Car>();
        cars.add(car);
        cars.add(car1);
        when(carService.carRepository.findAll()).thenReturn(cars);
        when(carService.carRepository.findById(anyLong())).thenReturn(car);
        when(carService.carRepository.saveAndFlush(any(Car.class))).thenReturn(car);
    }

    @Test
    public void getAllShouldReturnCorrectListOfCar() {
        List<Car> cars1 = carService.getAllCar();
        Assert.assertEquals(cars1, cars);
    }

    @Test
    public void getByIdShouldReturnCorrectCar() {
        Assert.assertEquals(carService.getById(1L), car);
    }

    @Test
    public void addCarShouldAddCar() {
        Assert.assertEquals(carService.addCar(car), car);
    }
    @Test
    public void  changeCarShouldReturnCorrectCar(){
        Car car1 = new Car();
        car1.setId(1L);
        Assert.assertEquals(carService.editCar(car1,manufacture,model,1000000,1.0), car);
    }
}
