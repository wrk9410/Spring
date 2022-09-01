package kr.co.greenart;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myset")
//@Primary // 1순위 출력으로 지정
public class MySetRepository implements MyDataRepository {
	@Autowired
	private Set<Integer> set;
	
	@Override
	public Iterable<Integer> getMyNumbers() {
		return set;
	}
	
}
