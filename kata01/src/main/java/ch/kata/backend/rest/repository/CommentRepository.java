package ch.kata.backend.rest.repository;

import ch.kata.backend.rest.data.Comment;
import org.springframework.data.repository.ListCrudRepository;

public interface CommentRepository extends ListCrudRepository<Comment, Long> {
}
