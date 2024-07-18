package ch.kata.backend.rest.repository;

import ch.kata.backend.rest.data.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post, Long> {
}
