package kr.co.greenart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 비어있으면 기본적으로 모든 Controller에서 적용됨 | ()로 설정하여 특정 클래스, 패키지, 어노테이션 등만 적용되게 설정 가능
public class ErrorHandler {
	@ExceptionHandler(value = NullPointerException.class) // 예외를 핸들러할 수 있는 어노테이션
	public String nullExcep(Model model, NullPointerException ex) {
		model.addAttribute("error", "서버에서 오류가 발생했습니다. 죄송 ㅋㅋ ㅈㅅ." + ex.getMessage());
		// getMessage: 해당 컨트롤러가 적용된 메소드의 throw를 출력
		return "errorpage";
	}
}
