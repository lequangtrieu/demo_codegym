package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/server")
public class HelloController {
    @RequestMapping(value = "/hello/{user}", method = RequestMethod.GET)
    public String hello(Model model, @PathVariable("user") String account){
        model.addAttribute("user", account);
        return "hello";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public ModelAndView hello2(@RequestParam(value = "user", required = false) String user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
