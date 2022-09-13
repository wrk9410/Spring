package kr.co.greenart.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.model.User;
import kr.co.greenart.model.UserService;
import kr.co.greenart.model.UserValidator;

@Controller
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

//	@Autowired // 바로 밑에있는 것만 취급하기에 여러개일 경우 여러번 작성해야함
//	private UserValidator validator;

	@Autowired
	private UserService service;

	@GetMapping("/user/list")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return "userlist";
	}

	@PostMapping("/user")
	public String submit(@ModelAttribute("user") @Valid User user, BindingResult errors) {
		// BindingResult는 Errors를 상속한 인터페이스이기에, Errors 객체를 가져올 때 사용
		logger.info("입력 정보: " + user.toString());

//		validator.validate(user, errors); 이거 대신 @Valid 사용

		if (errors.hasErrors() /* Errors가 한 개라도 있으면 true를 반환 */) {
			logger.info(errors.toString());
			return "userForm";
		}
		service.add(user);

		return "redirect:/user/list";
	} // ResquestBody에 들어가있는 값을 가져와서 이렇게 작동함 (@ModelAttribute("user") 이걸로 가져옴) ;

	@ModelAttribute("user")
	public User user() {
		return new User("기본값", 1);
	}

	@GetMapping("/user")
	public String userForm(@ModelAttribute("user") @Valid User user) {

		return "userForm";
	}

}
