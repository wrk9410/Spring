package mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Scope를 prototype으로
@Primary
public class ThirdComponent {
	private String value;
	private int num;
	
	@Autowired
	public void printValue(@Value(value = "vvvv") String value, @Value("100") int num) {
		// 파라미터에 특정값을 넣고 싶을 경우 @Value 사용, @Value(value(생략가능) = 값(String만 가능)) (타입) 변수명
		this.value = value;
		this.num = num;
	}
	
	public void printValue() {
		System.out.println(value);
		System.out.println(num);
	}
}
