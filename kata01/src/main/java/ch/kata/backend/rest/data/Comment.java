package ch.kata.backend.rest.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Comment(
        @Id Long id,
        Long postId,
        String name,
        String email,
        String body,
        @Version Long version
) {
}
