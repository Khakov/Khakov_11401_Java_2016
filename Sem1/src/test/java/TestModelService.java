import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.CarManufacture;
import ru.kpfu.itis.khakov.entity.Model;
import ru.kpfu.itis.khakov.entity.Motor;
import ru.kpfu.itis.khakov.repository.ManufactureRepository;
import ru.kpfu.itis.khakov.repository.ModelRepository;
import ru.kpfu.itis.khakov.service.ManufactureService;
import ru.kpfu.itis.khakov.service.ModelService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestModelService {
    private static ModelService modelService;
    private static List<Model> models;
    private static Model model;
    private static Motor motor;


    @BeforeClass
    public static void init() {
        modelService = new ModelService();
        modelService.modelRepository = mock(ModelRepository.class);
        model = new Model();
        motor = mock(Motor.class);
        model.setModel("Audi");
        model.setMotor(motor);
        model.setId(1L);
        model.setId(1L);
        Model model1 = model;
        model1.setId(2L);
        models = new ArrayList<Model>();
        models.add(model1);
        models.add(model);
        when(modelService.modelRepository.findAll()).thenReturn(models);
        when(modelService.modelRepository.findById(anyLong())).thenReturn(model);
        when(modelService.modelRepository.saveAndFlush(any(Model.class))).thenReturn(model);
    }

    @Test
    public void getAllShouldReturnCorrectListOfColor() {
        List<Model> models1 = modelService.getAll();
        Assert.assertEquals(models1, models);
    }

    @Test
    public void getByIdShouldReturnCorrectColor() {
        Assert.assertEquals(modelService.getById(1L), model);
    }
}
