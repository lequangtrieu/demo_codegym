package com.example.demo_login_page.service;

import com.example.demo_login_page.model.User;

public class UserService {
    public boolean checkLogin(User user) {
        return user.getUsername().equals("admin") && user.getPassword().equals("123456");
    }
}
