package com.company.contoller;

import com.company.model.User;
import com.company.repository.UserRepository;
import com.company.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/profile")
    String profilePage(@CookieValue(value = "token", required = false) String token, Model model) {
        Long userId = authenticationService.getUserIdByToken(token);

        if (userId == null) {
            return "redirect:/login";
        }
        User user = userRepository.getById(userId);

        model.addAttribute("user", user);

        return "profile";
    }

    @GetMapping("/login")
    String loginPage() {
        return "authorization";
    }

    @PostMapping("/login")
    String login(@RequestParam("login") String login, @RequestParam("password") String password,
                 HttpServletResponse response) {
        User user = userRepository.getByLogin(login);

        if (user == null || !user.getPassword().equals(password)) {
            return "redirect:/login";
        }
        String token = authenticationService.startSession(user.getId());
        response.addCookie(new Cookie("token", token));
        return "redirect:/profile";
    }

    @GetMapping("/logout")
    String logout(@CookieValue(value = "token", required = false) String token) {
        authenticationService.stopSession(token);
        return "redirect:/";
    }

    @GetMapping("/registration")
    String registrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    String registration(@RequestParam("login") String login, @RequestParam("password") String password,
                        @RequestParam("password2") String password2, HttpServletResponse response) {
        if (!password.equals(password2)) {
            return "redirect:/registration";
        }

        Long userId = userRepository.saveUser(new User(
                null, login, password, "Передаю", "привет",
                "про эти поля",
                "которые забыли",
                "",
                "фронтам"
                ));
        String session = authenticationService.startSession(userId);
        response.addCookie(new Cookie("token", session));
        return "redirect:/profile";
    }
}
