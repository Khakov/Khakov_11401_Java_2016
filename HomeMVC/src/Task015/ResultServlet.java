package Task015;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Рустам on 01.10.2015.
 */
@Controller
@RequestMapping("/result")
public class ResultServlet extends HttpServlet {
    @RequestMapping(method = RequestMethod.GET)
    public String getResult(ModelMap model, @RequestParam("result") int result, @RequestParam("oper") String oper){
        model.put("oper", oper);
        model.put("result",result);
        return "result";
    }
}
