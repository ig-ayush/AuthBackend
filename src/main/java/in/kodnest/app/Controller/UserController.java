package in.kodnest.app.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.kodnest.app.Entities.User;
import in.kodnest.app.Service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/auth/login")
	public Map<String, String> loginImplementaion(@RequestBody Map<String, String> request) {
		
		String username = request.get("username");
		String password = request.get("password");
		
		User authUser = userService.loginValidation(username, password);
		
		Map<String, String> response = new HashMap<>();
		
		response.put("username", authUser.getUsername());
		response.put("message", "Login Successfull");
		
		return response;
	}
	
}
