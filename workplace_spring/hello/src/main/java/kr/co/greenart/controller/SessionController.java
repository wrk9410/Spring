package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mysql.cj.Session;

@Controller
@RequestMapping(value = "/session", produces = "text/plain; charset=utf-8")
@SessionAttributes("modelname") // model에 값을 넣어도 사라졌지만 이거 추가하니깐 안사라졌음 | 단, 이 클래스 내에서만 저장되어 다른 컨트롤러에서는 없는 것처럼 나옴
@ResponseBody
public class SessionController {
	
	// 범위 크기 : HttpSession < SessionAttributes < request범위
	
	@GetMapping("/add")
	public String addSessionValue(HttpSession session) {
		session.setAttribute("myname", "myvalue");
		return "세션에 값 설정";
	}

	@GetMapping("/check")
	public String getSessionValue(HttpSession session) {
		return (String) session.getAttribute("myname");
	}

	@GetMapping("/model")
	public String addModelValue(Model model) {
		model.addAttribute("modelname", "modelvalue");
		return "모델의 값 설정";
	}

	@GetMapping("/modelcheck")
	public String getModelValue(Model model) {
		// request범위처럼 작동해서 SessionAttributes 넣어야함
		return (String) model.getAttribute("modelname");
	}
	
	@GetMapping("/status")
	public String complete(SessionStatus status) {
		status.setComplete(); // SessionAttributes로 들어간 값(ModelAttributes)만 삭제해줌
		return "세션 어트리뷰트 삭제되었음";
	}
	
	
	
	
	
	
	
	
	
	

}
