package ch.kata.backend.rest.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Setter(AccessLevel.NONE)
    Long id;
    String name;
    String username;
    String email;
    @Version
    @Setter(AccessLevel.NONE)
    Long version;
}
