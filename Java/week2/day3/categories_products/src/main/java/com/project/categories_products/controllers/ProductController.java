package com.project.categories_products.controllers;

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

import com.project.categories_products.models.Product;
import com.project.categories_products.services.ProductService;

@Controller
public class ProductController{
	private ProductService productService;

	public ProductController(ProductService productService){
		this.productService=productService;
	}

	@PostMapping("/products/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult res) {
		productService.create(product);
		return "redirect:/";
	}

}
