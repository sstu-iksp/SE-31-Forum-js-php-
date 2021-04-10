package com.company.contoller;

import com.company.model.Post;
import com.company.repository.PostRepository;
import com.company.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    String homePage(@CookieValue(value = "token", required = false) String token, Model model) {
        model.addAttribute("posts", postRepository.findAll());

        Long userId = authenticationService.getUserIdByToken(token);

        model.addAttribute("authenticated", userId != null);

        return "index";
    }

    @PostMapping("/post")
    String createPost(@CookieValue("token") String token, @RequestParam("title") String title,
                      @RequestParam("text") String text) {
        Long userId = authenticationService.getUserIdByToken(token);
        if (userId == null) {
            return "redirect:/login";
        }

        postRepository.save(new Post(null, userId, title, text));

        return "redirect:/";
    }
}
