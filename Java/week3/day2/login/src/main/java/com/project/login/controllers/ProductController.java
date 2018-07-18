package com.project.login.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.project.login.services.ProductService;
import com.project.login.models.Product;


@Controller
@RequestMapping("/products")
public class ProductController{
    
    @Autowired
	private ProductService productService;
	
    @GetMapping("")
	public String newproducts(Model model) {
        model.addAttribute("product", new Product());
		model.addAttribute("products", productService.all());
		return "products";
	}
	
    @PostMapping("")        
    public String createProduct(@Valid @ModelAttribute("product") Product product,BindingResult result){
        if (result.hasErrors()) {
			return "products";
		}
		productService.create(product);
		return "redirect:/";
    }

}