import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.CarManufacture;
import ru.kpfu.itis.khakov.entity.Color;
import ru.kpfu.itis.khakov.repository.ManufactureRepository;
import ru.kpfu.itis.khakov.service.ManufactureService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestManufactureService {
    private static ManufactureService manufactureService;
    private static List<CarManufacture> manufactures;
    private static CarManufacture manufacture;


    @BeforeClass
    public static void init() {
        manufactureService = new ManufactureService();
        manufactureService.manufactureRepository = mock(ManufactureRepository.class);
        manufacture = new CarManufacture();
        manufacture.setManufacture("Audi");
        manufacture.setId(1L);
        manufacture.setId(1L);
        CarManufacture manufacture1 = manufacture;
        manufacture1.setId(2L);
        manufactures = new ArrayList<CarManufacture>();
        manufactures.add(manufacture1);
        manufactures.add(manufacture);
        when(manufactureService.manufactureRepository.findAll()).thenReturn(manufactures);
        when(manufactureService.manufactureRepository.findById(anyLong())).thenReturn(manufacture);
        when(manufactureService.manufactureRepository.saveAndFlush(any(CarManufacture.class))).thenReturn(manufacture);
    }

    @Test
    public void getAllShouldReturnCorrectListOfColor() {
        List<CarManufacture> manufactures1 = manufactureService.getAll();
        Assert.assertEquals(manufactures1, manufactures);
    }

    @Test
    public void getByIdShouldReturnCorrectColor() {
        Assert.assertEquals(manufactureService.getById(1L), manufacture);
    }

}
