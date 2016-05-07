import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.service.MyUserDetailService;
import ru.kpfu.itis.khakov.service.UserService;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rus on 06.05.2016.
 */
public class TestMyUserService {
    private static UserService userService;
    private  static MyUserDetailService userDetailsService;
    private static User user;

    @BeforeClass
    public static void init(){
        userDetailsService = new MyUserDetailService();
        user = new User();
        user.setEnabled(false);
        user.setLogin("login");
        user.isAccountNonLocked();
        user.isEnabled();
        user.isAccountNonExpired();
        user.isCredentialsNonExpired();
        userDetailsService.userService= mock(UserService.class);
        when(userDetailsService.userService.getByLogin(anyString())).thenReturn(user);
    }

    @Test
    public void GetUserShouldBeWork(){
        Assert.assertEquals(user, userDetailsService.loadUserByUsername("user"));
    }
}
