package fa.training.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.springmvc.entities.ProductEntity;
import fa.training.springmvc.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService prdService;
	
	@RequestMapping(path = "/productlist", method = RequestMethod.GET)
	public String getAllProduct(Model view) {
		List<ProductEntity> prdList = prdService.getProducts();
		view.addAttribute("productList", prdList);
		
		return "product_list";
	}
	
	//@RequestMapping(path = "/add_product", method = RequestMethod.GET)
	@GetMapping("/add_product")
	public String addProduct(Model model) {
		model.addAttribute("product", new ProductEntity());
		return "product";
	}
	
	//@RequestMapping(path = "/add_product", method = RequestMethod.POST)
	@PostMapping("/add_product")
	public String addProduct(Model model, @ModelAttribute("product") ProductEntity product) {
		if (product.getId() != 0) {
			prdService.updateProduct(product);
		} else {
			prdService.addProduct(product);
		}
		return "redirect:/productlist";
	}
	
	@GetMapping("/update_product")
	public String updateProduct(Model model, @RequestParam("productId") int prdId) {
		ProductEntity product = prdService.getProduct(prdId);
		model.addAttribute("product", product);
		return "product";
	}
}
