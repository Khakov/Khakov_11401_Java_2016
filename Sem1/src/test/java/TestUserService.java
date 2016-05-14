import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.Type;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.TypeRepository;
import ru.kpfu.itis.khakov.repository.UserRepository;
import ru.kpfu.itis.khakov.service.TypeService;
import ru.kpfu.itis.khakov.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 12.05.2016.
 */
public class TestUserService {
    private static UserService userService;
    private static List<User> users;
    private static User user;


    @BeforeClass
    public static void init() {
        userService = new UserService();
        userService.userRepository = mock(UserRepository.class);
        user = new User();
        user.setEnabled(true);
        user.setFirstName("first name");
        user.setLastName("last name");
        user.setLogin("login@login.com");
        user.setId(1L);
        user.setNumber("123");
        user.setRole("ROLE_USER");
        user.setPassword("123456");
        User user1 = user;
        user1.setId(2L);
        users = new ArrayList<User>();
        users.add(user1);
        users.add(user);
        when(userService.userRepository.findAll()).thenReturn(users);
        when(userService.userRepository.findById(anyLong())).thenReturn(user);
        when(userService.userRepository.saveAndFlush(any(User.class))).thenReturn(user);
        when(userService.userRepository.saveAndFlush(any(User.class))).thenReturn(user);
        when(userService.userRepository.findAllByOrderByEnabledDesc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByEnabledAsc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByFirstNameAsc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByFirstNameDesc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByLastNameDesc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByLastNameAsc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByIdDesc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByLoginAsc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByLoginDesc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByRoleDesc()).thenReturn(users);
        when(userService.userRepository.findAllByOrderByRoleAsc()).thenReturn(users);
    }

    @Test
    public void getAllShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.getAllUsers();
        Assert.assertEquals(users1, users);
    }

    @Test
    public void getByIdShouldReturnCorrectUser() {
        Assert.assertEquals(userService.getById(1L), user);
    }

    @Test
    public void addShouldAddUser() {
        User user1 = new User();
        user1.setEnabled(true);
        user1.setFirstName("first name");
        user1.setLastName("last name");
        user1.setLogin("login@login.com");
        user1.setId(1L);
        user1.setNumber("123");
        user1.setRole("ROLE_USER");
        user1.setPassword("123456");
        System.out.println(user1);
        System.out.println(user);
        Assert.assertEquals(userService.add(user1), user);
    }

    @Test
    public void changeUserShouldChangeUser() {
        Assert.assertEquals(userService.changeUser(1L,"USER_ROLE",true), user);
    }

    @Test
    public void getAllByOrderByEnableAscShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByEnableAsc();
        Assert.assertEquals(users1, users);
    }
    @Test
    public void getAllByOrderByEnableDescShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByEnableDesc();
        Assert.assertEquals(users1, users);
    }
    @Test
    public void getAllByOrderByLoginAscShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByLoginAsc();
        Assert.assertEquals(users1, users);
    }
    @Test
    public void getAllByOrderByLoginDescShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByLoginDesc();
        Assert.assertEquals(users1, users);
    }

    @Test
    public void getAllByOrderByRoleAscShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByRoleAsc();
        Assert.assertEquals(users1, users);
    }

    @Test
    public void getAllByOrderByRoleDescShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByRoleDesc();
        Assert.assertEquals(users1, users);
    }

    @Test
    public void getAllByOrderByFirstNameAscShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByFirstNameAsc();
        Assert.assertEquals(users1, users);
    }
    @Test
    public void getAllByOrderByFirstNameDescShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByFirstNameDesc();
        Assert.assertEquals(users1, users);
    }
    @Test
    public void getAllByOrderByLastNameAscShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByLastNameAsc();
        Assert.assertEquals(users1, users);
    }
    @Test
    public void getAllByOrderByLarstNameDescShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByLastNameDesc();
        Assert.assertEquals(users1, users);
    }

    @Test
    public void getAllByOrderByIdDescShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.OrderByIdDesc();
        Assert.assertEquals(users1, users);
    }
}
