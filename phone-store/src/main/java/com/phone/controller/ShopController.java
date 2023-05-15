package com.phone.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.phone.entity.Product;
import com.phone.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShopController {

	private final ProductService productService;
	
	@GetMapping("/shop")
	public String doShowShop(Model model) {
		List<Product> products = productService.getAllByIsActive();
		model.addAttribute("products", products);
		return "user/shop";
	}
}
