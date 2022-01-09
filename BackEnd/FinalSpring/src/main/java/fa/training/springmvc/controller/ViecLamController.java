/**
 * @author HauHP
 * @date 6 thg 1, 2022
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

import fa.training.springmvc.dto.ViecLamDto;
import fa.training.springmvc.entities.ViecLam;
import fa.training.springmvc.service.ViecLamService;

@Controller
@RequestMapping("viecLam")
public class ViecLamController {
	@Autowired
	private ViecLamService viecLamService;

	@GetMapping("/create")
	public String createCustomerForm(Model model) {
		model.addAttribute("viecLamDto", new ViecLamDto());
		return "/viecLam/create";
	}

	@PostMapping("/create")
	public String createCustomer(@Valid @ModelAttribute ViecLamDto viecLamDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (viecLamService.isIdExist(viecLamDto.getMaVL())) {
			bindingResult.rejectValue("maVL", "error.viecLam.exist");
		}
		new ViecLamDto().validate(viecLamDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/viecLam/create";
		} else {
			ViecLam viecLam = new ViecLam();
			BeanUtils.copyProperties(viecLamDto, viecLam);
			viecLamService.save(viecLam);
			redirectAttributes.addFlashAttribute("message", "tao thanh cong viec lam co ma: " + viecLam.getMaVL());
			return "redirect:/viecLam/list";
		}
	}

	@GetMapping("/list")
	public String showCustomerList(@RequestParam("keyWord") Optional<String> keyWord,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
		List<ViecLam> viecLams;
		List<ViecLam> viecLamsToPaging;
		String key = "";
		if (keyWord.isPresent()) {
			System.out.println("da vao search "+ keyWord.get());
			viecLams = viecLamService.findByNamePage(keyWord.get(), PageRequest.of(page, size)).getContent();
			key = keyWord.get();
			viecLamsToPaging = viecLamService.findByName(keyWord.get());
		} else {
			viecLams = viecLamService.findAll(PageRequest.of(page, size)).getContent();
			viecLamsToPaging = viecLamService.findAll();
		}
		
		model.addAttribute("viecLams", viecLams);
		model.addAttribute("keyWord", key);
		int totalPage = viecLamsToPaging.size() / size + ((viecLamsToPaging.size() % size) == 0 ? 0 : 1);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return "/viecLam/list";
	}

	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam String maVL, RedirectAttributes redirectAttributes) throws Exception {
		if (maVL != null) {
			viecLamService.delete(maVL);
			redirectAttributes.addFlashAttribute("message", "xoa thanh cong ma viec lam  " + maVL);
		}
		return "redirect:/viecLam/list";
	}

	@GetMapping("/edit/{maVL}")
	public ModelAndView showEditPage(@PathVariable String maVL, Model model) {
		ModelAndView modelAndView = new ModelAndView("viecLam/edit", "viecLamDto",
				viecLamService.findById(maVL));
		return modelAndView;
	}

	@PostMapping("/edit")
	public String editCustomer(@Valid @ModelAttribute ViecLamDto viecLamDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) throws Exception {
//	        if (customerService.isCustomerCodeExist(customerDto.getMaKH())){
//				bindingResult.rejectValue("maKH", "error.customer.exist");
//	        }
		new ViecLamDto().validate(viecLamDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/viecLam/edit";
		} else {
			ViecLam viecLam = new ViecLam();
			BeanUtils.copyProperties(viecLamDto, viecLam);
			viecLamService.save(viecLam);
			redirectAttributes.addFlashAttribute("message", "cap nhat thanh cong ma viec lam : " + viecLam.getMaVL());
			return "redirect:/viecLam/list";
		}
	}

}
