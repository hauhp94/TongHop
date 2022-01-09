/**
 * @author HauHP
 * @date 24 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.springmvc.dto.CustomerDto;
import fa.training.springmvc.entities.Customer;
import fa.training.springmvc.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/create")
	public String createCustomerForm(Model model) {
		model.addAttribute("customerDto", new CustomerDto());
		return "/customer/02-tao-moi-khach-hang";
	}

	@PostMapping("/create")
	public String createCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (customerService.isCustomerCodeExist(customerDto.getMaKH())) {
			bindingResult.rejectValue("maKH", "error.customer.exist");
		}
		new CustomerDto().validate(customerDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/customer/02-tao-moi-khach-hang";
		} else {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDto, customer);
			customerService.save(customer);
			redirectAttributes.addFlashAttribute("message", "create success, customer: " + customer.getTenKH());
			return "redirect:/customer/list";
		}
	}

	@GetMapping("/list")
	public String showCustomerList(@RequestParam("keyWord") Optional<String> keyWord,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
		List<Customer> customers;
		List<Customer> customersToPaging;
		String key = "";
		if (keyWord.isPresent()) {
			System.out.println("da vao search "+ keyWord.get());
			customers = customerService.findByNamePage(keyWord.get(), PageRequest.of(page, size)).getContent();
			key = keyWord.get();
			customersToPaging = customerService.findByName(keyWord.get());
		} else {
			customers = customerService.findAll(PageRequest.of(page, size)).getContent();
			customersToPaging = customerService.getList();
		}
		
		model.addAttribute("customers", customers);
		model.addAttribute("keyWord", key);
		int totalPage = customersToPaging.size() / size + ((customersToPaging.size() % size) == 0 ? 0 : 1);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return "/customer/05-danh-sach-khach-hang";
	}

	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam String maKH, RedirectAttributes redirectAttributes) throws Exception {
		if (maKH != null) {
			customerService.delete(maKH);
			redirectAttributes.addFlashAttribute("message", "xoa thanh cong ma khach hang  " + maKH);
		}
		return "redirect:/customer/list";
	}

	@GetMapping("/edit/{maKH}")
	public ModelAndView showEditPage(@PathVariable String maKH, Model model) {
		ModelAndView modelAndView = new ModelAndView("customer/sua-khach-hang", "customerDto",
				customerService.getCustomerByCode(maKH));
		return modelAndView;
	}

	@PostMapping("/edit")
	public String editCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) throws Exception {
//	        if (customerService.isCustomerCodeExist(customerDto.getMaKH())){
//				bindingResult.rejectValue("maKH", "error.customer.exist");
//	        }
		new CustomerDto().validate(customerDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/customer/sua-khach-hang";
		} else {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDto, customer);
			customerService.save(customer);
			redirectAttributes.addFlashAttribute("message", "update success, customer: " + customer.getTenKH());
			return "redirect:/customer/list";
		}
	}

}
