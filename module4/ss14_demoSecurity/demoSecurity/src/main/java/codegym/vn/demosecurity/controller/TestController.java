package codegym.vn.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/role/index")
    public String role() {
        return "role";
    }
    @GetMapping("/admin/index")
    public String admin() {
        return "admin";
    }

    @GetMapping("/deny")
    public String deny() {
        return "accessdeny";
    }
}
