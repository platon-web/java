package org.example.culinaryblog.Controlles;

import org.example.culinaryblog.Models.User;
import org.example.culinaryblog.Repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "Pages/home";
    }
    @Autowired
    private IUserRepository iUserRepository;
    @GetMapping("/login")
    public String showLoginForm() {
        return "Pages/log-in";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (username.isEmpty() || password.isEmpty()) {
            return "redirect:/login?error=empty";
        }
        for(User user : iUserRepository.findAll()) {
            if (user.getEmail().equals(username)) {
                return "redirect:/profile/" + user.getId();
            }
        }
        return "redirect:/login?error=invalid";
    }
    @GetMapping("/registration")
    public String showRegisterForm() {
        return "Pages/registration";
    }
    @PostMapping("/registration")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return "redirect:/registration?error=empty";
        }
        User user = new User(name, email, password);
        iUserRepository.save(user);
        return "redirect:/profile/" + user.getId();
    }
    @GetMapping("/profile/{id}")
    public String profile(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("users", iUserRepository.findById(id));
        return "Pages/profile";
    }
    @GetMapping("/contact")
    public String contact() {
        return "Pages/contact";
    }
    @GetMapping("/about")
    public String about() {
        return "Pages/about";
    }
}