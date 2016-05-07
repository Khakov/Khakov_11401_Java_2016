import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.entity.MyCar;
import ru.kpfu.itis.khakov.repository.AttributeRepository;
import ru.kpfu.itis.khakov.service.AttributesService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestAttributeService {
    private static AttributesService attributesService;
    private static List<Attribute> attributes;
    private static Attribute attribute;
    private static List<MyCar> cars;


    @BeforeClass
    public static void init() {
        cars = new ArrayList<MyCar>();
        cars.add(mock(MyCar.class));
        cars.add(mock(MyCar.class));
        attributesService = new AttributesService();
        attributesService.attributeRepository = mock(AttributeRepository.class);
        attribute = new Attribute();
        attribute.setPrice(1000);
        attribute.setName("hello");
        attribute.setDescription("hi");
        Attribute attribute1 = new Attribute();
        attribute1 = attribute;
        attribute1.setCars(cars);
        attribute1.setId(2L);
        attributes = new ArrayList<Attribute>();
        attributes.add(attribute1);
        attributes.add(attribute);
        when(attributesService.attributeRepository.findAll()).thenReturn(attributes);
        when(attributesService.attributeRepository.findById(anyLong())).thenReturn(attribute);
        when(attributesService.attributeRepository.saveAndFlush(any(Attribute.class))).thenReturn(attribute);
    }

    @Test
    public void getAllShouldReturnCorrectListOfColor() {
        List<Attribute> attributes1 = attributesService.getAll();
        Assert.assertEquals(attributes1, attributes);
    }

    @Test
    public void getByIdShouldReturnCorrectColor() {
        Assert.assertEquals(attributesService.getById(1L), attribute);
    }

    @Test
    public void addCarShouldAddColor() {
        Assert.assertEquals(attributesService.addAttribute("hello","hi",1000), attribute);
    }
}
