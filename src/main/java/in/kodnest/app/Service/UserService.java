package in.kodnest.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kodnest.app.Entities.User;
import in.kodnest.app.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User loginValidation(String username, String password) {
		User user = userRepo.findByUsername(username);
		
		if(user == null) {
			throw new RuntimeException("User Not Found"); 
		}
		
		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("Invalid Password");
		}
		
		return user;
	}
	
}
