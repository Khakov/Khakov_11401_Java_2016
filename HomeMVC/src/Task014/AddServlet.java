package Task014;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;

/**
 * Created by Рустам on 01.10.2015.
 */
@Controller
@RequestMapping("{oper:mult|add}/{first}/{second}")
public class AddServlet extends HttpServlet {
    @RequestMapping(method = RequestMethod.GET)
    public String calculate(ModelMap model, @PathVariable String oper,  @PathVariable("first") int first,
                           @PathVariable("second") int second){
        String result = first + " * " + second + " = " + (first * second);
        if(oper.equals("add"))
            result = first + " + " + second + " = " + (first + second);
        model.put("result", result);
        return "oper";
    }
}