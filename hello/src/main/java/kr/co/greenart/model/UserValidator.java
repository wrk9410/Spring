package kr.co.greenart.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { // User 타입만 검사
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// target: 유효성 체크를 할 객체, errors: 메시지를 넣을 곳
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "이름을 입력하세요");
		// 1: errors 2.필드명 3.자유로운 코드라는 것을 적으면 됨 4.띄울 메세지
		
		User user = (User) target;
		if (user.getName().length() > 5) {
			errors.rejectValue("name", "name.toolong", "이름이 너무 깁니다"); // errors(Errors).rejectValue("필드명", "자유로운 코드 작성", "출력시킬 내용")
		}
		if (user.getAge() > 200) {
			errors.rejectValue("age", "age.tooold", "나이 범위를 초과했습니다.");
		}
//		if (user.getName().contains("") || user.getAge() < 0) {
//			errors.rejectValue("name");
//			
//		}
	}
	
}
