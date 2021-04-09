package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HomePageController {

    @GetMapping
    String getMainPage(Model model) {
       /* model.addAttribute("posts", Arrays.asList(
                new Post(1l, "Titleasdasd", "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ipsa excepturi vitae ipsum libero non. Voluptas, voluptates, ducimus commodi libero voluptatibus veritatis quas doloribus soluta quam beatae ut nobis ad minus?", 1l, 1l),
                new Post(1l, "Title!!!!!", "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ipsa excepturi vitae ipsum libero non. Voluptas, voluptates, ducimus commodi libero voluptatibus veritatis quas doloribus soluta quam beatae ut nobis ad minus?", 1l, 1l),
                new Post(1l, "Title", "Loreus commodi libero voluptatibus veritatis quas doloribus soluta quam beatae ut nobis ad minus?", 1l, 1l),
                new Post(1l, "Title", "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ipsa excepturi vitae ipsum libero non. Voluptas, voluptates, ducimus commodi libero voluptatibus veritatis quas doloribus soluta quam beatae ut nobis ad minus?", 1l, 1l)
        ));

*/
        return "index.html";
    }
}
