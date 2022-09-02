package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/handle")
public class HandlerMethodArgs {
	@GetMapping("/cookie") // 쿠키값 볼 수 있음
	public @ResponseBody String args(@CookieValue(name = "JSESSIONID") String jsessionid) {
		return jsessionid;
	}
	
	@GetMapping("/header") // 헤더값 볼 수 있음
	public @ResponseBody String head(@RequestHeader("Accept") String contentType) {
		return contentType;
	}
	
	@GetMapping("/{path1}/{path2}") // handle 다음에 오는 /값은 path1, 그 다음에 오는 /값은 path2에 저장되어 가져올 수 있음
	public @ResponseBody String paths(@PathVariable String path1, @PathVariable String path2) {
		return path1 + path2;
	}
}
