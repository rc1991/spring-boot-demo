package hello.controller;

import hello.bo.HelloBO;
import hello.dao.DemoRepository;
import hello.po.DemoPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private DemoRepository repository;

    @GetMapping("")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "visitor") String name,
                        Model model) {
        List<DemoPO> list = repository.findAll();
        HelloBO bo = new HelloBO(name, list);
        model.addAttribute("bo", bo);
        return "hello/index";
    }
}
