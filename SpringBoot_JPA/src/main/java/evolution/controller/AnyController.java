package evolution.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import evolution.entity.common.User;
import evolution.entity.many2Many.Post;
import evolution.entity.many2Many.Tag;
import evolution.repository.PostRepository;
import evolution.repository.UserRepository;

@RestController
public class AnyController {
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private PostRepository postRepository;

	@GetMapping("/common/insert")
	public User commonInsert() {
		User user = new User();
		user.setName("Chen");
		user.setEmail("fslichen@126.com");
		userRepository.save(user);
		return user;
	}
	
	@GetMapping("/many/2/many/insert")
	public List<Post> many2ManyInsert() {
		Post post0 = new Post();
		post0.setTitle("post0");
		Post post1 = new Post();
		post1.setTitle("post1");
		Tag tag0 = new Tag();
		tag0.setName("tag0");
		Tag tag1 = new Tag();
		tag1.setName("tag1");
		post0.setTags(Arrays.asList(tag0, tag1));
		post1.setTags(Arrays.asList(tag0, tag1));
		postRepository.save(post0);
		postRepository.save(post1);
		return Arrays.asList(post0, post1);
	}

	@GetMapping("/many/2/many/find/all")
	public void many2ManyFindAll() {
		Iterable<Post> posts = postRepository.findAll();
		posts.forEach(System.out::println);
	}
	
	@GetMapping("/common/find/all")
	public Iterable<User> commonFindAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/common/find/by/name/and/email")
	public Iterable<User> commonFindByNameAndEmail() {
		return userRepository.findByNameAndEmail("Chen", "fslichen@126.com");
	}
}
