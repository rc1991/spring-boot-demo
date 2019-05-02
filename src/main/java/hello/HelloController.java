package hello;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HelloController {

    @GetMapping("/hello")
    public String index(Model model, @RequestParam(value="name", required=false, defaultValue="visitor") String name) {
        model.addAttribute("name", name);
        return "hello/hello";
    }
}
