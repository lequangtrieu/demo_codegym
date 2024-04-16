package codegym.vn.demosecurity.controller;

import codegym.vn.demosecurity.entity.User;
import codegym.vn.demosecurity.entity.UserRole;
import codegym.vn.demosecurity.repository.RoleRepository;
import codegym.vn.demosecurity.repository.UserRepository;
import codegym.vn.demosecurity.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("user") User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "index";
    }

    @GetMapping("/addRole")
    public String showAddRole(Model model) {
        model.addAttribute("userRole", new UserRole());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "/user/addRole";
    }

    @PostMapping("/addRole")
    public String addRole(@ModelAttribute("userRole") UserRole userRole) {
        userRoleRepository.save(userRole);
        return "index";
    }
}

