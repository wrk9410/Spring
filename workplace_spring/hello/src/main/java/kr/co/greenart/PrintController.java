package kr.co.greenart;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// "/print" GET 요청 시 -> text 입력 가능 form으로 forward
// form.jsp submit할 때 "/print" POST 요청 -> 입력한 text 그대로를 볼 수 있는 (view)print.jsp로 forward

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
