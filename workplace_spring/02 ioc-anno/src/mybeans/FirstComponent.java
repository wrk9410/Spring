package mybeans;

import org.springframework.stereotype.Component;

@Component(value = "firstComp")
// value = "(id�� ���� ����)", �����ص� �����
public class FirstComponent {
	public void hello() {
		System.out.println("������̼����� Bean �����ϱ� ����");
	}
}
