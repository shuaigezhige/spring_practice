package self.terence.practice.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
//    public String hello(@RequestParam(name = "name") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
    public String index() {
        return "index";
    }
}
