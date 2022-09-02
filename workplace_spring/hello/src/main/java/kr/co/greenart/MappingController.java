package kr.co.greenart;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {
	@GetMapping(value = "/??.two", produces = "text/plain; charset=utf-8") // ?: 물음표 횟수만큼의 글자수만 실행함
	public @ResponseBody String two() {
		return "두글자 매핑";
	}
	
	@GetMapping("/*.do") // .do가 붙는 모든 것들을 실행함
	public @ResponseBody String doURI() {
		return "do로 끝나는 매핑";
	}
	
	@GetMapping(value = "/ppp", params = "com")
	/* @GetMapping(value = "/ppp", params = "com=val")
	 * params = "(파라미터이름)": 파라미터이름이 있어야지만 정상 요청해줌
	 * (파라미터이름)="해당 값이여야만 실행": 파라미터 값이 설정값일 때만 정상 요청해줌"
	 * 
	 * @GetMapping(value = "/ppp", params = "!com")
	 * !(파라미터명): com이라는 파라미터가 없어야 정상 요청해줌
	*/
	public @ResponseBody String ppp(@RequestParam(defaultValue = "default") String com) {
		return "ppp";
	}
}
