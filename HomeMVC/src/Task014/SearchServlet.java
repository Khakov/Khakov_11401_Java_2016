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
@RequestMapping("/{search:bing\\.com|baidu\\.com|yahoo\\.com|aol\\.com}")
public class SearchServlet extends HttpServlet {
    @RequestMapping(method = RequestMethod.GET)
    public String bing(ModelMap model, @PathVariable String search) {
        String path = "http://bing.com/search";
        String text = "q";
        if (search.equals("aol.com")) {
            path="http://search." + search + "/aol/search";
        }
        if(search.equals("baidu.com")){
            text = "wd";
            path = "https://"+search +"/s";
        }
        if(search.equals("yahoo.com")){
            path = "https://"+search+"/search";
            text = "p";
        }
        model.put("path", path);
        model.put("search", search);
        model.put("text", text);
        return "search";
    }
}
