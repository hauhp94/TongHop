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

import fa.training.springmvc.dto.DangKyLamThemDto;
import fa.training.springmvc.entities.DangKyLamThem;
import fa.training.springmvc.service.DangKyLamThemService;
import fa.training.springmvc.service.ViecLamService;
@Controller
@RequestMapping("dangKyLamThem")
public class DangKyLamThemController {
	@Autowired
	private DangKyLamThemService dangKyLamThemService;
	
	@Autowired
	private ViecLamService viecLamService;

	@GetMapping("/create")
	public String createCustomerForm(Model model) {
		model.addAttribute("dangKyLamThemDto", new DangKyLamThemDto());
		return "/dangKyLamThem/create";
	}

	@PostMapping("/create")
	public String createCustomer(@Valid @ModelAttribute DangKyLamThemDto dangKyLamThemDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if (dangKyLamThemService.isIdExist(dangKyLamThemDto.getMaDK())) {
			bindingResult.rejectValue("maDK", "error.dangky.exist");
		}
		if (!viecLamService.isIdExist(dangKyLamThemDto.getMaVL())) {
			bindingResult.rejectValue("maVL", "error.vieclam.khongtontai");
			System.out.println("khong ton tai viec lam");
		}else {
			if (viecLamService.findById(dangKyLamThemDto.getMaVL()).getTrangThai().equals("Closed")) {
				bindingResult.rejectValue("maVL", "error.vieclam.dong");
			}
		}
		
		new DangKyLamThemDto().validate(dangKyLamThemDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/dangKyLamThem/create";
		} else {
			DangKyLamThem dangKyLamThem = new DangKyLamThem();
			BeanUtils.copyProperties(dangKyLamThemDto, dangKyLamThem);
			dangKyLamThem.setTongTien(Integer.parseInt(dangKyLamThem.getCapBac())*dangKyLamThem.getSoNgayCong());
			dangKyLamThemService.save(dangKyLamThem);
			redirectAttributes.addFlashAttribute("message", "dang ky thanh cong viec lam co ma: " + dangKyLamThem.getMaVL());
			return "redirect:/dangKyLamThem/list";
		}
	}

	@GetMapping("/list")
	public String showCustomerList(@RequestParam("keyWord") Optional<String> keyWord,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
		List<DangKyLamThem> dangKyLamThems;
		List<DangKyLamThem> dangKyLamThemsToPaging;
		String key = "";
		if (keyWord.isPresent()) {
			System.out.println("da vao search "+ keyWord.get());
			dangKyLamThems = dangKyLamThemService.findByNamePage(keyWord.get(), PageRequest.of(page, size)).getContent();
			key = keyWord.get();
			dangKyLamThemsToPaging = dangKyLamThemService.findByName(keyWord.get());
		} else {
			dangKyLamThems = dangKyLamThemService.findAll(PageRequest.of(page, size)).getContent();
			dangKyLamThemsToPaging = dangKyLamThemService.findAll();
		}
		
		model.addAttribute("dangKyLamThems", dangKyLamThems);
		model.addAttribute("keyWord", key);
		int totalPage = dangKyLamThemsToPaging.size() / size + ((dangKyLamThemsToPaging.size() % size) == 0 ? 0 : 1);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return "/dangKyLamThem/list";
	}

	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam String maDK, RedirectAttributes redirectAttributes) throws Exception {
		if (maDK != null) {
			dangKyLamThemService.delete(maDK);
			redirectAttributes.addFlashAttribute("message", "xoa thanh dang ky co ma  " + maDK);
		}
		return "redirect:/dangKyLamThem/list";
	}

	@GetMapping("/edit/{maDK}")
	public ModelAndView showEditPage(@PathVariable String maDK, Model model) {
		ModelAndView modelAndView = new ModelAndView("dangKyLamThem/edit", "dangKyLamThemDto",
				dangKyLamThemService.findById(maDK));
		return modelAndView;
	}

	@PostMapping("/edit")
	public String editCustomer(@Valid @ModelAttribute DangKyLamThemDto dangKyLamThemDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) throws Exception {
//	        if (customerService.isCustomerCodeExist(customerDto.getMaKH())){
//				bindingResult.rejectValue("maKH", "error.customer.exist");
//	        }
		int soNgayTruoc = dangKyLamThemService.findById(dangKyLamThemDto.getMaDK()).getSoNgayCong();
		int soNgaySau = dangKyLamThemDto.getSoNgayCong();
		if (soNgayTruoc<soNgaySau) {
			bindingResult.rejectValue("soNgayCong", "error.ngayCong.khongHopLe");
		}
		new DangKyLamThemDto().validate(dangKyLamThemDto, bindingResult);
		if (bindingResult.hasFieldErrors()) {
			return "/dangKyLamThem/edit";
		} else {
			DangKyLamThem dangKyLamThem = new DangKyLamThem();
			BeanUtils.copyProperties(dangKyLamThemDto, dangKyLamThem);
			dangKyLamThem.setTongTien(Integer.parseInt(dangKyLamThem.getCapBac())*dangKyLamThem.getSoNgayCong());
			dangKyLamThemService.save(dangKyLamThem);
			redirectAttributes.addFlashAttribute("message", "Update thong tin dang ky viec lam them thanh cong " + dangKyLamThemDto.getMaDK());
			return "redirect:/dangKyLamThem/list";
		}
	}
}
