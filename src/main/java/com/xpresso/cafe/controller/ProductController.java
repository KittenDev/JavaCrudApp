package com.xpresso.cafe.controller;

import com.xpresso.cafe.model.Product;
import com.xpresso.cafe.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/product_list";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/product_list";
    }

    @RequestMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") String id, Model model) {
        Product p = productService.getProductById(id);
        model.addAttribute("product", p);
        return "productUpdate";
    }

    @GetMapping("/product_add")
    public String productAdd() {
        return "productAdd";
    }

    @GetMapping("/product_list")
    public ModelAndView getAllProduct() {
        List<Product>list = productService.getAllProduct();

        return new ModelAndView("product", "productList", list);
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return "redirect:/product_list";
    }
}
