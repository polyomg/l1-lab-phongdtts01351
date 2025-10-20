package poly.edu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import poly.edu.service.ShoppingCartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ShoppingCartService cartService;

    @GetMapping("/add/{id}")
    public Object add(@PathVariable("id") Integer id) {
        return cartService.add(id);
    }

    @GetMapping("/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        cartService.remove(id);
    }

    @GetMapping("/update/{id}/{qty}")
    public Object update(@PathVariable("id") Integer id, @PathVariable("qty") int qty) {
        return cartService.update(id, qty);
    }

    @GetMapping("/clear")
    public void clear() {
        cartService.clear();
    }

    @GetMapping("/items")
    public Object items() {
        return cartService.getItems();
    }

    @GetMapping("/count")
    public int count() {
        return cartService.getCount();
    }

    @GetMapping("/amount")
    public double amount() {
        return cartService.getAmount();
    }
}
