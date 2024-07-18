package ch.kata.backend.rest.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record User(
        @Id Long id,
        String name,
        String username,
        String email,
        @Version Long version
) {
}
