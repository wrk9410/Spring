package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.greenart.config.RootConfig;
import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional // roll1.트랜잭션 설정
// @TransactionConfiguration(defaultRollback = true) << 스프링 4버전 이하
public class CarServiceTest {
	@Autowired
	private CarService service;
	
	@Test(expected = DataAccessException.class) // expected = (예외명): (예외명)의 예외가 발생해야 통과되게 설정
	public void bulkInsert() {
		List<Car> list = Arrays.asList(new Car(0, "AAA", 100)
				, new Car(0, "BBB", 100)
				, new Car(0, "AAA", 100)
				, new Car(0, "CCC", 100));
		
		int[] result = service.bulkInsert(list);
		assertNull(result);
	}
	
	@Test
	@Rollback(value = true) // roll2.롤백 하는 명령어 | 삭제, 추가, 업데이트 상관없이 무조건 롤백
	public void delete() {
		int result = service.delete(1);
		
		assertEquals(1, result);
	}
	
	
}
