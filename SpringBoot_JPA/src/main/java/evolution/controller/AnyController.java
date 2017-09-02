package evolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import evolution.entity.User;
import evolution.repository.UserRepository;

@RestController
public class AnyController {
	@Autowired 
	private UserRepository userRepository;

	@GetMapping("/insert")
	public User addNewUser (@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return user;
	}

	@GetMapping("/find/all")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/find/by/name")
	public List<User> findByName(@RequestParam String name) {
		return userRepository.findByName(name);
	}
}
