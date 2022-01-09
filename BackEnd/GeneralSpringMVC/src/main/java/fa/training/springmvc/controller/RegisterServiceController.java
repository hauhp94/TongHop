/**
 * @author HauHP
 * @date 28 thg 12, 2021
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

import fa.training.springmvc.dto.CustomerDto;
import fa.training.springmvc.dto.RegisterServiceDto;
import fa.training.springmvc.entities.Customer;
import fa.training.springmvc.entities.RegisterService;
import fa.training.springmvc.entities.Service;
import fa.training.springmvc.service.CustomerService;
import fa.training.springmvc.service.RegisterServiceService;
import fa.training.springmvc.service.ServiceService;

@Controller
@RequestMapping("registerService")
public class RegisterServiceController {
	@Autowired
	private RegisterServiceService registerServiceService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private CustomerService customerService;

	@GetMapping("/create")
	public String createForm(Model model) {
		List<String> danhSachMaDichVu = new ArrayList<String>();
		for (Service service : serviceService.getList()) {
			danhSachMaDichVu.add(service.getMaDV());
		}
		List<String> danhSachMaKhachHang = new ArrayList<String>();
		for (Customer customer : customerService.getList()) {
			danhSachMaKhachHang.add(customer.getMaKH());
		}
		model.addAttribute("danhSachMaDichVu", danhSachMaDichVu);
		model.addAttribute("danhSachMaKhachHang", danhSachMaKhachHang);
		model.addAttribute("registerServiceDto", new RegisterServiceDto());
		return "/register/dang-ky-dich-vu";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute RegisterServiceDto registerServiceDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		new RegisterServiceDto().validate(registerServiceDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			List<String> danhSachMaDichVu = new ArrayList<String>();
			for (Service service : serviceService.getList()) {
				danhSachMaDichVu.add(service.getMaDV());
			}
			List<String> danhSachMaKhachHang = new ArrayList<String>();
			for (Customer customer : customerService.getList()) {
				danhSachMaKhachHang.add(customer.getMaKH());
			}
			model.addAttribute("danhSachMaDichVu", danhSachMaDichVu);
			model.addAttribute("danhSachMaKhachHang", danhSachMaKhachHang);
			return "/register/dang-ky-dich-vu";
		} else {
			System.out.println(registerServiceDto.getMaKH());
			System.out.println(registerServiceDto.getMaDV());
			RegisterService registerService = new RegisterService();
			BeanUtils.copyProperties(registerServiceDto, registerService);
			registerServiceService.save(registerService);
			redirectAttributes.addFlashAttribute("message", "create success, registerComputer: "
					+ registerService.getMaKH() + " - " + registerService.getMaDV());
			return "redirect:/registerService/list";
		}
	}

	@GetMapping("/list")
	public String showRegisterList(Model model) {
		List<RegisterService> registerServices;
		registerServices = registerServiceService.getList();
		model.addAttribute("registerServices", registerServices);
		return "/register/danh-sach-dang-ky-dich-vu";
	}

}
