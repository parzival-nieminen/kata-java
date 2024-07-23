package ch.kata.backend.rest.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends BaseEntity {

    Long postId;
    String name;
    String email;
    @Column(columnDefinition = "TEXT")
    String body;

}
