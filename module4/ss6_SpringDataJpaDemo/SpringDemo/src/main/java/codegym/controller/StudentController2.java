package codegym.controller;

import codegym.form.StudentForm;
import codegym.model.Student;
import codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/studentorm")
public class StudentController2 {
    @Autowired
    StudentService studentService;

    @GetMapping("create")
    public String displayCreate(Model model) {
        model.addAttribute("student", new Student());
        return "student2/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("student") Student stu, Model model) {
        studentService.save(stu);
        return "redirect:/studentorm/listStudent";
    }

    @GetMapping("detail/{id}")
    public String displayDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student2/detail";
    }

    @GetMapping("listStudent")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getList());
        return "student2/list";
    }

    @GetMapping("listStudentPaging")
    public String listStudent(@RequestParam(value = "page", required = false, defaultValue = "0")
                                      int pageNumber, @RequestParam(value = "record", required = false, defaultValue = "10")
                                      int pageRecords, Model model) {
        model.addAttribute("students", studentService.getListWithPaging(pageNumber, pageRecords));
        return "student2/list";
    }
}
