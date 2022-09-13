package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET) // 주소값 설정, 해당 주소를 요청할 경우 특정한 view로 이동하게 설정
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET) // method = RequestMethod.GET = 배열 형태로 할 경우 GET과 POST 두 가지 다 가능
	public String hi() {
		return "hello";
	}
}
