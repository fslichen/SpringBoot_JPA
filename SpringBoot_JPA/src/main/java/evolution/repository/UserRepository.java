package evolution.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import evolution.entity.common.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public List<User> findByName(String name);
	
	public List<User> findByNameAndEmail(String name, String email);
}
