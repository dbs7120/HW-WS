package com.ssafy.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.SearchDto;
import com.ssafy.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/mvadd")
	public String mvadd() {
		return "add";
	}

	@RequestMapping("/mvdelete")
	public String mvdelete() {
		return "delete";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "searchWord", required = false) String searchWord, Model model) {

		List<ProductDto> list = productService.allProduct(new SearchDto(searchWord, searchType));
		model.addAttribute("products", list);
		return "list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("product_id") int product_id, Model model) {
		productService.deleteProduct(product_id);
		return "redirect:list?searchType=&searchWord=";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(ProductDto productDto, Model model) {
		productService.addProduct(productDto);
		return "redirect:list?searchType=&searchWord=";
	}
}
