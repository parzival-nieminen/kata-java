package ch.kata.backend.rest.infrastructur;

import ch.kata.backend.rest.data.Comment;
import ch.kata.backend.rest.data.Post;
import ch.kata.backend.rest.data.User;
import ch.kata.backend.rest.repository.CommentRepository;
import ch.kata.backend.rest.repository.PostRepository;
import ch.kata.backend.rest.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;


@Slf4j
@Component
public class JsonFileDataLoader implements CommandLineRunner {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    ObjectMapper objectMapper;
    PostRepository postRepository;

    public JsonFileDataLoader(ObjectMapper objectMapper, PostRepository postRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.objectMapper = objectMapper;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        JsonNode json;

        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/post-data.json")) {
            json = objectMapper.readValue(inputStream, JsonNode.class);
        } catch (IOException ioException) {
            log.info("Failed to load data", ioException.getCause());
            throw new RuntimeException("Failed to load data", ioException.getCause());
        }

        JsonNode posts = getPosts(json);
        posts.forEach(it -> postRepository.save(objectMapper.convertValue(it, Post.class)));
        log.info("Loaded {} posts", posts.size());

        JsonNode comments = getComments(json);
        comments.forEach(it -> commentRepository.save(objectMapper.convertValue(it, Comment.class)));
        log.info("Loaded {} comments", comments.size());

        JsonNode users = getUsers(json);
        users.forEach(it -> userRepository.save(objectMapper.convertValue(it, User.class)));
        log.info("Loaded {} users", users.size());
    }

    private JsonNode getPosts(JsonNode jsonNode) {
        return Optional.ofNullable(jsonNode)
                .map(j -> j.get("posts"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid JSON - posts not found"));
    }

    private JsonNode getComments(JsonNode jsonNode) {
        return Optional.ofNullable(jsonNode)
                .map(j -> j.get("comments"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid JSON - comments not found"));
    }

    private JsonNode getUsers(JsonNode jsonNode) {
        return Optional.ofNullable(jsonNode)
                .map(j -> j.get("users"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid JSON - users not found"));
    }

}
