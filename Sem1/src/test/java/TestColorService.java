import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Color;
import ru.kpfu.itis.khakov.repository.ColorRepository;
import ru.kpfu.itis.khakov.service.ColorService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestColorService {
    private static ColorService colorService;
    private static List<Color> colors;
    private static Color color;


    @BeforeClass
    public static void init() {
        colorService = new ColorService();
        colorService.colorRepository = mock(ColorRepository.class);
        color = new Color();
        color.setColorEn("white");
        color.setColorRu("белый");
        color.setId(1L);
        Color color1 = new Color();
        color1.setColorEn("black");
        color1.setColorRu("черный");
        color1.setId(2L);
        colors = new ArrayList<Color>();
        colors.add(color1);
        colors.add(color);
        when(colorService.colorRepository.findAll()).thenReturn(colors);
        when(colorService.colorRepository.findById(anyLong())).thenReturn(color);
        when(colorService.colorRepository.saveAndFlush(any(Color.class))).thenReturn(color);
    }

    @Test
    public void getAllShouldReturnCorrectListOfColor() {
        List<Color> colors1 = colorService.getAll();
        Assert.assertEquals(colors1, colors);
    }

    @Test
    public void getByIdShouldReturnCorrectColor() {
        Assert.assertEquals(colorService.getById(1L), color);
    }

    @Test
    public void addCarShouldAddColor() {
        Assert.assertEquals(colorService.addColor(color), color);
    }
}
