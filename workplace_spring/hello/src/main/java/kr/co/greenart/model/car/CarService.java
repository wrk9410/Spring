package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {
	@Autowired
	// @Qualifier("이름"): Bean의 이름 작성
	private CarRepository repo;
	
	public List<Car> list() {
		return repo.getAll();
	}
	
	public Car getById(int id) {
		return repo.getById(id);
	}
	
	public int add(Car car) {
		return repo.add(car);
	}
	
	public int update(Car car) {
		return repo.update(car);
	}
	
	// 자동차 목록을 전달받아 추가
	@Transactional // tran3.트랜잭션 필요하다고 입력(RootConfig에 1,2 있음)
	public int[] bulkInsert(List<Car> list) {
//		int[] result = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			result[i] = repo.add(list.get(i));
//		}
		int[] results = repo.batchInsert(list); // 위 코드랑 동일한 실행
		return results;
	}

	@Transactional
	public int delete(int id) {
		return repo.delete(id);
	}
	
}
