import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.entity.CarManufacture;
import ru.kpfu.itis.khakov.entity.Page;
import ru.kpfu.itis.khakov.repository.ManufactureRepository;
import ru.kpfu.itis.khakov.repository.PageRepository;
import ru.kpfu.itis.khakov.service.ManufactureService;
import ru.kpfu.itis.khakov.service.PageService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestPageService {
    private static PageService pageService;
    private static List<Page> pages;
    private static Page page;
    private static Car car;

    @BeforeClass
    public static void init() {
        pageService = new PageService();
        pageService.pageRepository = mock(PageRepository.class);
        page = new Page();
        car = mock(Car.class);
        page.setCar(car);
        page.setId(1L);
        Page page1 = page;
        page1.setId(2L);
        pages = new ArrayList<Page>();
        pages.add(page1);
        pages.add(page);
        when(pageService.pageRepository.findByCar(any(Car.class))).thenReturn(pages);
        when(pageService.pageRepository.saveAndFlush(any(Page.class))).thenReturn(page);
    }

    @Test
    public void getByCarShouldReturnCorrectListOfPages() {
        List<Page> pages1 = pageService.getByCar(car);
        Assert.assertEquals(pages1, pages);
    }

}
