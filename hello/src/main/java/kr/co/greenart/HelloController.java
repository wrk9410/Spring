package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET) // �ּҰ� ����, �ش� �ּҸ� ��û�� ��� Ư���� view�� �̵��ϰ� ����
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET) // method = RequestMethod.GET = �迭 ���·� �� ��� GET�� POST �� ���� �� ����
	public String hi() {
		return "hello";
	}
}
