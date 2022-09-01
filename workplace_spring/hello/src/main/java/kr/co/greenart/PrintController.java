package kr.co.greenart;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// "/print" GET ��û �� -> text �Է� ���� form���� forward
// form.jsp submit�� �� "/print" POST ��û -> �Է��� text �״�θ� �� �� �ִ� (view)print.jsp�� forward

@Controller
public class PrintController {
	
	@RequestMapping(value="/print", method = RequestMethod.GET)
	public String prin() {
		
		return "form";
	}
	
	@RequestMapping(value="/print", method = RequestMethod.POST)
	public String form(HttpServletRequest request, @RequestParam String param, Model model) throws UnsupportedEncodingException {
		model.addAttribute("prin", param);
		System.out.println(param);
		return "print";
	}
}
