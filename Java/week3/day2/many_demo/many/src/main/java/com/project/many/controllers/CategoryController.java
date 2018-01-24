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

import com.project.many.services.CategoryService;
import com.project.many.services.ProductService;
import com.project.many.services.CatProService;

import com.project.many.models.Category;

@Controller
@RequestMapping("/categories")
public class CategoryController{
	private CatProService catProService;
	private CategoryService categoryService;
	private ProductService productService;

	public CategoryController(CategoryService categoryService,ProductService productService,CatProService catProService){
		this.categoryService=categoryService;
		this.productService=productService;
		this.catProService=catProService;
	}
	
	@RequestMapping("/new")
	public String showCategory(@ModelAttribute("goodbye") Category category){
		return "category";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("goodbye") Category category,BindingResult res){
		if(res.hasErrors()){
			return "redirect:/new";
		}else{
			categoryService.create(category);
			return "redirect:/categories/new";
		}
	}

	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute("products",productService.all());
		model.addAttribute("categories",categoryService.all());
		return "category_product";
	}

	@PostMapping("/add")
	public String join(@RequestParam("category_id") long category_id,@RequestParam("product_id") long product_id){
		catProService.join(category_id,product_id);
		return "redirect:/categories/add";
	}
}
