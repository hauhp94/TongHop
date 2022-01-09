/**
 * @author HauHP
 * @date 28 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.springmvc.entities.Customer;
import fa.training.springmvc.service.CustomerUsingService;

@Controller
@RequestMapping("customerUsing")
public class CustomerUsingController {
	@Autowired
	private CustomerUsingService customerUsingService;

	@GetMapping("list")
	public String getList(Model model) {
		model.addAttribute("customerUsings", customerUsingService.getList());
		model.addAttribute("map", customerUsingService.totalMoneyMap());
		return "/register/khach-hang-dich-vu";
	}
	
	@GetMapping("list1")
	public String getList1(Model model) {
		List<Customer> customers = customerUsingService.getListCustomer();
		System.out.println(customers.size()+" day la size customer");
		model.addAttribute("customers", customers);
		model.addAttribute("map", customerUsingService.totalMoneyMap());
		return "/register/khach-hang-dich-vu";
	}

}
