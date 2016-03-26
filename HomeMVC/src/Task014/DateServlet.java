package Task014;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import java.util.Date;

/**
 * Created by Рустам on 01.10.2015.
 */
@Controller
@RequestMapping("/date")
public class DateServlet extends HttpServlet {
     @RequestMapping(method = RequestMethod.GET)
        public String datePage(ModelMap model){
            model.put("time", new Date());
            return "date";
        }
}
