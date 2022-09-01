package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // 이름은 변경이 가능함(중복가능)
public class MyService {
	@Autowired
	@Qualifier(value = "mylist") // value에 해당하는 id를 값을 가져옴
	private MyDataRepository repo;
	
	public Iterable<Integer> numberService() {
		return repo.getMyNumbers();
	}
}
