package com.example.Task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/add")
    public String addItemPage(Model model) {
        model.addAttribute("item", new Item());
        return "additem";
    }

    @GetMapping("/get")
    public String getItemPage() {
        return "getitembyid";
    }


    }

    

