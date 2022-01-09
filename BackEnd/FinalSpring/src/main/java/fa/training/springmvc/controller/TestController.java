/**
 * @author HauHP
 * @date 4 thg 1, 2022
 * @version 1.0
 */
package fa.training.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/test")
	public String getTestPage(Model model) {
		model.addAttribute("message", "hello test");
		return "test";
	}

}
