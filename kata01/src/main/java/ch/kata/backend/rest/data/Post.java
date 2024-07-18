package ch.kata.backend.rest.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Post(
        @Id Long id,
        Long userId,
        String title,
        String body,
        @Version Long version
) {
}
