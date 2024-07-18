package ch.kata.backend.rest.controller;

import ch.kata.backend.rest.data.Comment;
import ch.kata.backend.rest.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllPost() {
        var foo = commentRepository.findAll();
        return new ResponseEntity<>(foo,HttpStatus.OK);
    }
}
