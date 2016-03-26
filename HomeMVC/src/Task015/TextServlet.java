package Task015;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import java.util.Date;
import java.util.regex.*;

/**
 * Created by Рустам on 01.10.2015.
 */
@Controller
@RequestMapping("/process")
public class TextServlet extends HttpServlet {
    @RequestMapping(method = RequestMethod.GET)
    public String getText(){
        return "text";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String getText(ModelMap model, @RequestParam("read") String oper, @RequestParam("text") String text){
        Pattern p = Pattern.compile("\\.");
        int i = 0;
        if (oper.equals("sentences")) {
            p = Pattern.compile("[\\.?!]+");
        }
        if (oper.equals("words")) {
            i++;
            p = Pattern.compile("\\s(\\w+)");
        }
        if (oper.equals("symbols")) {
            p = Pattern.compile(".");
        }
        if (oper.equals("paragraphs")) {
            i++;
            p = Pattern.compile("\\n");
        }
        Matcher m = p.matcher(text);
        while (m.find())
            i++;
        model.put("oper", oper);
        model.put("result",i);
        return "redirect:/result";
    }
}
