import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Type;
import ru.kpfu.itis.khakov.repository.TypeRepository;
import ru.kpfu.itis.khakov.service.TypeService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 12.05.2016.
 */
public class TestTypeService {
    private static TypeService typeService;
    private static List<Type> types;
    private static Type type;


    @BeforeClass
    public static void init() {
        typeService = new TypeService();
        typeService.typeRepository = mock(TypeRepository.class);
        type = new Type();
        type.setType("type");
        type.setId(1L);
        Type type1 = new Type();
        type1.setType("type");
        type1.setId(2L);
        types = new ArrayList<Type>();
        types.add(type1);
        types.add(type);
        when(typeService.typeRepository.findAll()).thenReturn(types);
        when(typeService.typeRepository.findById(anyLong())).thenReturn(type);
        when(typeService.typeRepository.saveAndFlush(any(Type.class))).thenReturn(type);
        when(typeService.typeRepository.saveAndFlush(any(Type.class))).thenReturn(type);
    }

    @Test
    public void getAllShouldReturnCorrectListOfType() {
        List<Type> types1 = typeService.getAllTypes();
        Assert.assertEquals(types1, types);
    }

    @Test
    public void getByIdShouldReturnCorrectType() {
        Assert.assertEquals(typeService.getById(1L), type);
    }

    @Test
    public void addShouldAddType() {
        Assert.assertEquals(typeService.add("type"), type);
    }
}
