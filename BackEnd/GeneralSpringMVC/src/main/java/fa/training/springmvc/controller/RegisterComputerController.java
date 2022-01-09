/**
 * @author HauHP
 * @date 27 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.springmvc.dto.RegisterComputerDto;
import fa.training.springmvc.entities.Computer;
import fa.training.springmvc.entities.Customer;
import fa.training.springmvc.entities.RegisterComputer;
import fa.training.springmvc.service.ComputerService;
import fa.training.springmvc.service.CustomerService;
import fa.training.springmvc.service.RegisterComputerService;

@Controller
@RequestMapping("registerComputer")
public class RegisterComputerController {
	@Autowired
	private RegisterComputerService registerComputerService;
	@Autowired
	private ComputerService computerService;
	@Autowired
	private CustomerService customerService;

	@GetMapping("/create")
	public String createCustomerForm(Model model) {
		List<String> danhSachMaMay = new ArrayList<String>();
		for (Computer computer : computerService.getList()) {
			danhSachMaMay.add(computer.getMaMay());	
		}
		List<String> danhSachMaKhachHang = new ArrayList<String>();
		for (Customer customer : customerService.getList()) {
			danhSachMaKhachHang.add(customer.getMaKH());	
		}
		
		
	

        
		model.addAttribute("danhSachMaMay",danhSachMaMay);
		model.addAttribute("danhSachMaKhachHang", danhSachMaKhachHang);
		model.addAttribute("registerComputerDto", new RegisterComputerDto());
		return "/register/dang-ky-may";
	}

	@PostMapping("/create")
	public String createCustomer(@Valid @ModelAttribute RegisterComputerDto registerComputerDto,
			BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasFieldErrors()) {
			List<String> danhSachMaMay = new ArrayList<String>();
			for (Computer computer : computerService.getList()) {
				danhSachMaMay.add(computer.getMaMay());	
			}
			List<String> danhSachMaKhachHang = new ArrayList<String>();
			for (Customer customer : customerService.getList()) {
				danhSachMaKhachHang.add(customer.getMaKH());	
			}
			model.addAttribute("danhSachMaMay",danhSachMaMay);
			model.addAttribute("danhSachMaKhachHang", danhSachMaKhachHang);
			return "/register/dang-ky-may";
		} else {
			RegisterComputer registerComputer = new RegisterComputer();
			BeanUtils.copyProperties(registerComputerDto, registerComputer);
			registerComputerService.save(registerComputer);
			redirectAttributes.addFlashAttribute("message", "create success, registerComputer: "
					+ registerComputer.getMaKH() + " - " + registerComputer.getMaMay());
			return "redirect:/registerComputer/list";
		}
	}

	@GetMapping("/list")
	public String showRegisterComputerList(Model model) {
		List<RegisterComputer> registerComputers;
		registerComputers = registerComputerService.getList();
		model.addAttribute("registerComputers", registerComputers);
		return "/register/danh-sach-dang-ky-may";
	}

}
