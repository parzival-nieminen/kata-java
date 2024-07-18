package ch.kata.backend.rest.controller;

import ch.kata.backend.rest.data.Comment;
import ch.kata.backend.rest.data.User;
import ch.kata.backend.rest.repository.CommentRepository;
import ch.kata.backend.rest.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllPost() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
