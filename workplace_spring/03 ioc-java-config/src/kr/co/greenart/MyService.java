package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // �̸��� ������ ������(�ߺ�����)
public class MyService {
	@Autowired
	@Qualifier(value = "mylist") // value�� �ش��ϴ� id�� ���� ������
	private MyDataRepository repo;
	
	public Iterable<Integer> numberService() {
		return repo.getMyNumbers();
	}
}
