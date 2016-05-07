import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Result;
import ru.kpfu.itis.khakov.repository.ResultRepository;
import ru.kpfu.itis.khakov.service.ResultService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestResultService {
    private static ResultService resultService;
    private static Result result;
    private static List<Result> results;



    @BeforeClass
    public static void init() {
        results = new ArrayList<Result>();
        resultService = new ResultService();
        resultService.resultRepository = mock(ResultRepository.class);
        result = new Result();
        result.setResult("result");
        result.setId(1L);
        results.add(result);
        results.add(result);
        when(resultService.resultRepository.findAll()).thenReturn(results);
        when(resultService.resultRepository.findByResult(anyString())).thenReturn(result);
    }

    @Test
    public void getByIdShouldReturnCorrectResult() {
        Assert.assertEquals(resultService.getByName("res"), result);
    }
    @Test
    public void getAllShouldReturnCorrectResult() {
        Assert.assertEquals(resultService.getAll(), results);
    }
}
