package codegym.controller;

import codegym.form.StudentForm;
import codegym.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    private static Map<Integer, Student> students = new HashMap<>();
    static {
        students.put(1, new Student(1, "Bao", 22, "Da Nang"));
        students.put(2, new Student(2, "Khanh", 23, "Da Nang"));
        students.put(3, new Student(3, "Lan", 21, "Da Nang"));
        students.put(4, new Student(4, "Huynh", 20, "Da Nang"));
    }

    @GetMapping("create")
    public String displayCreate(Model model) {
        model.addAttribute("student", new StudentForm());
        String[] items = new String[] {"Bóng đá", "Cầu lông", "Bóng rổ", "Du lịch"};
        model.addAttribute("itemsHobbies", items);
        return "student/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("student") StudentForm stu, Model model) {
        // convert data từ StudentForm về Student
        // students.add(stu);
        model.addAttribute("student", stu);
//        return "student/detail";
        return "detail";
    }

    @GetMapping("detail/{id}")
    public String displayDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", students.get(id));
        return "detail";
    }

    @GetMapping("listStudent")
    public String listStudent(Model model) {
        model.addAttribute("students", new ArrayList<>(students.values()));
        return "list";
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("user", "Linh");
        return "index";
    }
}
