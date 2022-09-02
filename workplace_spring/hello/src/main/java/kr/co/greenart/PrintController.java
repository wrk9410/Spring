package kr.co.greenart;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/print")
public class PrintController {

	@GetMapping
	public String printForm() {
		return "form";
	}

	@PostMapping
	public String printView(HttpServletRequest request, @RequestParam(value = "text") String textt, Model model) {
		model.addAttribute("text", textt);
		System.out.println(textt);
		return "print";
	}

	@GetMapping("/sub")
	public @ResponseBody String sub() {
		return "/print/sub";
	}

}
