package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

/* view없이 응답 body 보내기 */

@Controller
@RequestMapping("/car")
@ResponseBody // 클래스 위에 적으면 모든 mapping이 응답 body로 보내짐
public class CarController {
	private static Logger logger = LoggerFactory.getLogger(CarController.class);
	@Autowired
	private CarService service;
	
	@GetMapping
	public List<Car> view() { // @ResponseBody: return의 문자열이 응답 body로 보내짐
		// Spring에서는 JacksonDatabind 라이브러리가 있으면 이렇게만 적어도 인코딩과 응답body까지 가능
		/* 전체 목록보기 */
		return service.list();
	}
	
	@GetMapping("/{id}") // /{}: 경로를 변수처럼 사용가능
	public Car carById(@PathVariable int id) { // @PathVariable: 변수처럼 사용하는 경로의 값
		/* id에 해당하는 Car만 보기 */
		return service.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Car car) {
		logger.info(car.toString());
		service.add(car);
		/* POST로 전달받은 Car의  JSON방식 내용을 추가하기 */
		return ResponseEntity.ok("{ \"result\" : \"ok\"}");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Car car) {
		service.update(car);
		/* Put으로 전달받은 Car의 JSON방식 내용을 수정하기 */
		return ResponseEntity.ok("{ \"result\" : \"ok\"}");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\"}");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
