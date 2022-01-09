/**
 * @author HauHP
 * @date 27 thg 12, 2021
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

import fa.training.springmvc.dto.ServiceDto;
import fa.training.springmvc.entities.Service;
import fa.training.springmvc.service.ServiceService;

@Controller
@RequestMapping("service")
public class ServiceController {
	@Autowired
	private ServiceService serviceService;

	@GetMapping("/create")
	public String createServiceForm(Model model) {
		model.addAttribute("serviceDto", new ServiceDto());
		return "/service/03-tao-moi-dich-vu";
	}

	@PostMapping("/create")
	public String createService(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (serviceService.isServiceCodeExist(serviceDto.getMaDV())) {
			bindingResult.rejectValue("maDV", "error.service.exist");

		}
		new ServiceDto().validate(serviceDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/service/03-tao-moi-dich-vu";
		} else {
			Service service = new Service();
			BeanUtils.copyProperties(serviceDto, service);
			serviceService.save(service);
			redirectAttributes.addFlashAttribute("message", "create success, service: " + service.getTenDV());
			return "redirect:/service/list";
		}
	}

	@GetMapping("/list")
	public String showServiceList(@RequestParam("keyWord") Optional<String> keyWord,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
		List<Service> services;
		List<Service> servicesToPaging;
		String key = "";
		if (keyWord.isPresent()) {
			services = serviceService.findByNamePage(keyWord.get(), PageRequest.of(page, size)).getContent();
			key = keyWord.get();
			servicesToPaging = serviceService.findByName(keyWord.get());
		} else {
			services = serviceService.findAll(PageRequest.of(page, size)).getContent();
			servicesToPaging = serviceService.getList();
		}
		model.addAttribute("services", services);
		model.addAttribute("keyWord", key);
		int totalPage = servicesToPaging.size() / size + ((servicesToPaging.size() % size) == 0 ? 0 : 1);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);

		return "/service/06-danh-sach-dich-vu";
	}

	@PostMapping("/delete")
	public String deleteService(@RequestParam String maDV, RedirectAttributes redirectAttributes) throws Exception {
		if (maDV != null) {
			serviceService.delete(maDV);
			redirectAttributes.addFlashAttribute("message", "xoa thanh cong ma dich vu  " + maDV);
		}
		return "redirect:/service/list";
	}

	@GetMapping("/edit/{maDV}")
	public ModelAndView showEditPage(@PathVariable String maDV, Model model) {
		ModelAndView modelAndView = new ModelAndView("service/sua-dich-vu", "serviceDto",
				serviceService.getServiceByCode(maDV));
		return modelAndView;
	}

	@PostMapping("/edit")
	public String editCustomer(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) throws Exception {
		new ServiceDto().validate(serviceDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/service/sua-dich-vu";
		} else {
			Service service = new Service();
			BeanUtils.copyProperties(serviceDto, service);
			serviceService.save(service);
			redirectAttributes.addFlashAttribute("message", "update success, service: " + service.getMaDV());
			return "redirect:/service/list";
		}
	}
}
