package codegym.vn.controller;

import codegym.vn.entity.Student;
import codegym.vn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;
    // constructor injection
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list"
//            , consumes = {MediaType.APPLICATION_JSON_VALUE}
//            , produces = {MediaType.APPLICATION_JSON_VALUE}
//            , headers = {"Content-Type=application/json"}
            )
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @RequestMapping(value = {"/list2", "/"}, method = RequestMethod.GET)
    public String displayList2(ModelMap model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/detail/{id}/{name}")
    public String detail(@PathVariable(name = "id") String id,
                         @PathVariable(name = "name") String name,
                         Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("id") String id) {
//        ModelAndView model = new ModelAndView("student/detail");
        ModelAndView model = new ModelAndView();
        model.setViewName("student/detail");
        model.addObject("student", studentService.findById(id));
        return model;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Student student = new Student();
        String[] address = new String[] {"Đà Nẵng", "Huế", "Quảng Nam"};
        model.addAttribute("student", student);
        model.addAttribute("addresses", address);
        return "student/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "student") Student student, Model model, RedirectAttributes rd) {
        studentService.create(student);
        rd.addFlashAttribute("message", "Thêm mới student thành công");
        return "redirect:/student/list";
    }

    // setter injection
//    @Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }
}
