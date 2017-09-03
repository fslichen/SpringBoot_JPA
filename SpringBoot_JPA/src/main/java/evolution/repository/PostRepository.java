package evolution.repository;

import org.springframework.data.repository.CrudRepository;

import evolution.entity.many2Many.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
