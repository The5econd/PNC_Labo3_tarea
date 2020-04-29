package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class ProductController {

	private List<Product> productos = new ArrayList<Product>();

	@GetMapping("/compraProducto")
	public ModelAndView compraProducto(){
		ModelAndView mav = new ModelAndView();

		productos.add(new Product(0, "PS3", "80"));
		productos.add(new Product(1, "PS4", "40"));
		productos.add(new Product(2, "PS5", "30"));
		productos.add(new Product(3, "Xbox 360", "10"));
		productos.add(new Product(4, "Xbox One", "15"));
		productos.add(new Product(5, "Nintendo Switch", "100"));

		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		return mav;
	}

	@PostMapping("/validar")
	public ModelAndView compraProducto(Product product){
		ModelAndView mav = new ModelAndView();
		String availableQuantity = product.getCantidad();

		if(Integer.parseInt(availableQuantity) > Integer.parseInt(productos.get(product.getId()).getCantidad()) ) {
			mav.setViewName("error");
			mav.addObject("nombre", productos.get(product.getId()).getNombre());
			return mav;
		}else {
			mav.setViewName("compra");
			mav.addObject("nombre", productos.get(product.getId()).getNombre());
			return mav;
		}
	}
}