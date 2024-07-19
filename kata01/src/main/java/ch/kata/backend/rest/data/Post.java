package ch.kata.backend.rest.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    Long id;
    Long userId;
    String title;
    String body;
    @Version
    @Setter(AccessLevel.NONE)
    Long version;
}
