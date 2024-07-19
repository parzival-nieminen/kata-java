package ch.kata.backend.rest.controller;

import ch.kata.backend.rest.data.Comment;
import ch.kata.backend.rest.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        var commentList = commentRepository.findAll();
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable long id) {
        return commentRepository.findById(id)
                .map(it -> new ResponseEntity<>(it, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(Comment commentNew) {
        var savedComment = commentRepository.save(commentNew);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updatePost(@PathVariable Long id, @RequestBody Comment commentUpdate) {
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setName(commentUpdate.getName());
            comment.setBody(commentUpdate.getBody());
            comment.setEmail(commentUpdate.getEmail());
            Comment updatedPost = commentRepository.save(comment);
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
