package kr.co.greenart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrintController {

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String prin() {

		return "form";
	}

	@RequestMapping(value = "/print", method = RequestMethod.POST)
	public String form(@RequestParam String param, Model model) {
		model.addAttribute("prin", param);
		System.out.println(param);
		return "print";
	}
}
