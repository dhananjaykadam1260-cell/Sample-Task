package com.example.Task;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Handle form submission 
    @PostMapping("/add")
    public String addItem(@Valid @ModelAttribute Item item, Model model) {
        Item savedItem = itemService.addItem(item);
        model.addAttribute("item", savedItem);
        return "additem";
    }

    // Get item by ID 
    @PostMapping("/get")
    public String getItemById(@RequestParam Long id, Model model) {
        itemService.getItemById(id)
                .ifPresentOrElse(
                        item -> model.addAttribute("item", item),
                        () -> model.addAttribute("error", "Item not found")
                );
        return "getitembyid";
    }
}
