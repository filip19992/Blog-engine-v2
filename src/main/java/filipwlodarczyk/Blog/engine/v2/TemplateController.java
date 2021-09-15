package filipwlodarczyk.Blog.engine.v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("main-page")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("login")
      public String getlogin() {
          return "login";
    }
}
