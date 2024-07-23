package ch.kata.backend.rest.data;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {

    Long userId;
    String title;
    @Column(columnDefinition = "TEXT")
    String body;
}
