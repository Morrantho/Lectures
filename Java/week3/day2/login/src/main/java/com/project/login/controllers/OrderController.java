package com.project.login.controllers;

import com.project.login.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.login.models.CustomerOrder;
import com.project.login.models.Product;
import com.project.login.models.Customer;

import com.project.login.services.CustomerService;
import com.project.login.services.ProductService;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
	@Autowired
	private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String orders(Model model) {
		model.addAttribute("orders", orderService.all());
        model.addAttribute("customers",customerService.all());
        model.addAttribute("products",productService.all());
        model.addAttribute("order", new CustomerOrder());
        return "orders";
    }

    @PostMapping("")
    public String checkout(@RequestParam("customer") Long customerId, @RequestParam("product") Long productId ){
        Customer customer = customerService.findOne(customerId);
        Product product = productService.findOne(productId);

        CustomerOrder order = new CustomerOrder();
        order.setCustomer(customer);

        List<Product> products = order.getProducts();
        // if(products == null){
            // products = new ArrayList<Product>();
        // }

        products.add(product);

        order.setProducts(products);

        orderService.create(order);

        return "redirect:/orders";
    }
}