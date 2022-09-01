package mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Scope�� prototype����
@Primary
public class ThirdComponent {
	private String value;
	private int num;
	
	@Autowired
	public void printValue(@Value(value = "vvvv") String value, @Value("100") int num) {
		// �Ķ���Ϳ� Ư������ �ְ� ���� ��� @Value ���, @Value(value(��������) = ��(String�� ����)) (Ÿ��) ������
		this.value = value;
		this.num = num;
	}
	
	public void printValue() {
		System.out.println(value);
		System.out.println(num);
	}
}
