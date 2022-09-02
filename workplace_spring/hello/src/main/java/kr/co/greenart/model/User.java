package kr.co.greenart.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class User {
	@NotBlank(message = "이름을 입력해주세요") // 값이 없거나 공백이 있으면 Errors
	@Size(min = 1, max = 4, message = "이름은 1 ~ 4자 사이여야합니다.") // 문자열 길이 확인 min=최솟값, max=최댓값
	private String name;
	@Positive(message = "양수를 입력해주세요") // 음수일 경우 Errors
	@Max(value = 100, message = "최댓값(100)을 초과했습니다.") // 초과일 경우 Errors
	private int age;

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
