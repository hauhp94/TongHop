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

import fa.training.springmvc.dto.ComputerDto;
import fa.training.springmvc.entities.Computer;
import fa.training.springmvc.service.ComputerService;
@Controller
@RequestMapping("computer")
public class ComputerController {
	@Autowired
	private ComputerService computerService;

	@GetMapping("/create")
	public String createComputerForm(Model model) {
		model.addAttribute("computerDto", new ComputerDto());
		return "/computer/01-tao-moi-may";
	}

	@PostMapping("/create")
	public String createCustomer(@Valid @ModelAttribute ComputerDto computerDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (computerService.isComputerCodeExist(computerDto.getMaMay())) {
			bindingResult.rejectValue("maMay", "error.computer.exist");

		}
		new ComputerDto().validate(computerDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/computer/01-tao-moi-may";
		} else {
			Computer computer = new Computer();
			BeanUtils.copyProperties(computerDto, computer);
			computerService.save(computer);
			redirectAttributes.addFlashAttribute("message", "create success, computer: " + computer.getMaMay());
			return "redirect:/computer/list";
		}
	}

	@GetMapping("/list")
	public String showCustomerList(@RequestParam("keyWord") Optional<String> keyWord,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
		List<Computer> computers;
		List<Computer> computersToPaging;
		String key = "";
		if (keyWord.isPresent()) {
			computers = computerService.findByNamePage(keyWord.get(), PageRequest.of(page, size)).getContent();
			key = keyWord.get();
			computersToPaging = computerService.findByName(keyWord.get());
		} else {
			computers = computerService.findAll(PageRequest.of(page, size)).getContent();
			computersToPaging = computerService.getList();
		}
		model.addAttribute("computers", computers);
		model.addAttribute("keyWord", key);
		int totalPage = computersToPaging.size() / size + ((computersToPaging.size() % size) == 0 ? 0 : 1);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return "/computer/04-danh-sach-may";
	}

	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam String maMay, RedirectAttributes redirectAttributes) throws Exception {
		if (maMay != null) {
			computerService.delete(maMay);
			redirectAttributes.addFlashAttribute("message", "xoa thanh cong ma may  " + maMay);
		}
		return "redirect:/computer/list";
	}

	@GetMapping("/edit/{maMay}")
	public ModelAndView showEditPage(@PathVariable String maMay, Model model) {
		ModelAndView modelAndView = new ModelAndView("computer/sua-may", "computerDto",
				computerService.getComputerByCode(maMay));
		return modelAndView;
	}
	 @PostMapping("/edit")
	    public String editCustomer(@Valid @ModelAttribute ComputerDto computerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws Exception {

	        new ComputerDto().validate(computerDto, bindingResult);
	        if (bindingResult.hasFieldErrors()) {
				return "/computer/sua-may";
	        } else {
	            Computer computer = new Computer();
	            BeanUtils.copyProperties(computerDto, computer);
	            computerService.save(computer);
	            redirectAttributes.addFlashAttribute("message", "update success, computer: " + computer.getMaMay());
	            return "redirect:/computer/list";
	        }
	    }

}
