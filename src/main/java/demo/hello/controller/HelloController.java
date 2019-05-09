package demo.hello.controller;

import demo.hello.bo.HelloBO;
import demo.hello.po.DemoPO;
import demo.hello.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class HelloController {

    @Autowired
    private DemoRepository repository;

    @GetMapping({"/", "/hello"})
    public String index(HttpSession session, HttpServletResponse response,
                        @CookieValue(value = "username", required = false) String cookiename,
                        @RequestParam(value = "name", required = false) String name,
                        Model model) {

        if (name == null){
            name = cookiename == null? "visitor": cookiename;
        }
        session.setAttribute("username", name);
        if (!name.equals("visitor")) {
            Cookie cookie = new Cookie("username", name);
            response.addCookie(cookie);
        }
        List<DemoPO> list = repository.findAll();
        HelloBO bo = new HelloBO(name, list);
        model.addAttribute("bo", bo);
        return "hello/index";
    }
}
