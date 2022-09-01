package mybeans;

import org.springframework.stereotype.Component;

@Component(value = "firstComp")
// value = "(id랑 거의 동일)", 생략해도 실행됨
public class FirstComponent {
	public void hello() {
		System.out.println("어노테이션으로 Bean 설정하기 연습");
	}
}
