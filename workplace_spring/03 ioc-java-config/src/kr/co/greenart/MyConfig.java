package kr.co.greenart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정을 가지고 있는 Component, XML에서 수정하는 것들을 class에서도 수정가능하게 해줌
@ComponentScan(value = "kr.co.greenart")
public class MyConfig {
	@Bean // public (등록하려는 Bean의 타입) (id) { 내용 } 설정 후 반환해주면 List의 형태도 Bean으로 만들 수 있음
	public List<Integer> myList() {
		return new ArrayList<>(Arrays.asList(1,2,3,4,5));
	}
	
	@Bean // (value = "setMy") // 아래 내용 실행하는 id 설정
	public Set<Integer> mySet() {
		return new HashSet<>(Arrays.asList(1,2,3,4,5));
	}
}
