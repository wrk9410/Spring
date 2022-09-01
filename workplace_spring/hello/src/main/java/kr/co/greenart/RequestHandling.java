package kr.co.greenart;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestHandling {
	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);

	@RequestMapping(value = "/req", method = RequestMethod.GET)
	public String req(@RequestParam int param, @RequestParam int param2, Model model) { // Model: ��Ʈ����Ʈ ������ ������ �ִ� �ϳ��� Map���� ����
		logger.info(String.valueOf(param + param2));
		model.addAttribute("result", param + param2);

		return "plusresult";
	}

}
