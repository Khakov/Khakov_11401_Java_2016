import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Result;
import ru.kpfu.itis.khakov.entity.Status;
import ru.kpfu.itis.khakov.repository.ResultRepository;
import ru.kpfu.itis.khakov.repository.StatusRepository;
import ru.kpfu.itis.khakov.service.ResultService;
import ru.kpfu.itis.khakov.service.StatusService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 11.05.2016.
 */
public class TestStatusService {
    private static StatusService statusService;
    private static Status status;
    private static List<Status> statuses;



    @BeforeClass
    public static void init() {
        statuses = new ArrayList<Status>();
        statusService = new StatusService();
        statusService.statusRepository = mock(StatusRepository.class);
        status = new Status();
        status.setStatus("status");
        status.setId(1L);
        statuses.add(status);
        statuses.add(status);
        when(statusService.statusRepository.findAll()).thenReturn(statuses);
        when(statusService.statusRepository.findByStatus(anyString())).thenReturn(status);
        when(statusService.statusRepository.findById(anyLong())).thenReturn(status);
    }

    @Test
    public void getByStatusShouldReturnCorrectStatus() {
        Assert.assertEquals(statusService.getByStatus("status"), status);
    }
    @Test
    public void getAllShouldReturnCorrectStatus() {
        Assert.assertEquals(statusService.getAll(), statuses);
    }
    @Test
    public void getByIdShouldReturnCorrectStatus() {
        Assert.assertEquals(statusService.getById(1L), status);
    }
}
