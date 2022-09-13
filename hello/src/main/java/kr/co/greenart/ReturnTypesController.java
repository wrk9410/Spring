package kr.co.greenart;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/returns")
public class ReturnTypesController {
	@GetMapping("/viewname")
	public String viewname() {
		return "hello"; // WEB-INF에서 (입력값).jsp을 찾아 실행시켜줌
	}
	
	@GetMapping("/respbody")
	//@ResponseBody // 여기에 적어도 정상 실행
	public @ResponseBody String body() {
		return "body 내용";
	}
	
	@GetMapping("/mv")
	public ModelAndView mv() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "모델앤뷰 객체로 설정");
		mv.setViewName("plusresult"); // 해당 이름의 view파일을 찾아 가져옴
		return mv;
	}
	
	@GetMapping("/respentity")
	public ResponseEntity<String> entity() {
		// 응답 head, body 등을 설정하기
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, "text/plain; charset=utf-8")
				.body("바디 내용");
		
//		String body = "바디 내용 입니다"; HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/plain; charset=utf-8");
//		ResponseEntity<String> en = new ResponseEntity<>(body, headers,
//		HttpStatus.OK); return en;
		 
	}
	
	@GetMapping("/red")
	public String redirect() {
		// 설정한 경로로 redirect 하기
		return "redirect:/";
	}
	
}
