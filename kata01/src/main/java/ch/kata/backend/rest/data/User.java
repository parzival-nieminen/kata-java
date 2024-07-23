package ch.kata.backend.rest.data;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"USER\"")
public class User extends BaseEntity {

    String name;
    String username;
    String email;

}
