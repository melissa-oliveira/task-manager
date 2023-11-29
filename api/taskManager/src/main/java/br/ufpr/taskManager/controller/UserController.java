package br.ufpr.taskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpr.taskManager.entity.User;
import br.ufpr.taskManager.service.UserService;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User insert(@RequestBody User user) {
        user.setPassword(userService.hashSHA256(user.getPassword()));
        userService.create(user);
        return userService.findByEmail(user.getEmail());
    }

    @GetMapping("/user")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/user/email/{email}")
    public User findByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }
    
    @GetMapping("/user/login/{email}/{password}")
    public User login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.login(email, password);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
    	user.setPassword(userService.hashSHA256(user.getPassword()));
        return userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
}
