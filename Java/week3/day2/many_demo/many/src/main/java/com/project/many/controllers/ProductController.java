package com.project.many.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.many.services.ProductService;
import com.project.many.models.Product;

@Controller
@RequestMapping("/products")
public class ProductController{
	private ProductService productService;

	public ProductController(ProductService productService){
		this.productService=productService;
	}
	
	@RequestMapping("/new")
	public String showProduct(@ModelAttribute("hello") Product product){
		return "product";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product product,BindingResult res){
		if(res.hasErrors()){
			return "redirect:/new";
		}else{
			productService.create(product);
			return "redirect:/products/new";
		}	
	}
}
