package ch.kata.backend.rest.repository;

import ch.kata.backend.rest.data.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}
