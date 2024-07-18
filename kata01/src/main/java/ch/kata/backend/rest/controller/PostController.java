package ch.kata.backend.rest.controller;

import ch.kata.backend.rest.data.Post;
import ch.kata.backend.rest.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable long postId) {
        return postRepository.findById(postId)
                .map(it -> new ResponseEntity<>(it, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
