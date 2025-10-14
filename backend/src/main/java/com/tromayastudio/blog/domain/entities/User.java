package com.tromayastudio.blog.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity // because it's a JPA entity
@Table(name = "users") // specify the name of the table it's going to use in the database
// it means that Hibernate is going to generate a table called users in the database which this entity will map to
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,  orphanRemoval = true) // it means when a user is deleted all its posts will be deleted too
    private List<Post> posts =  new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, createdAt);
    }

    @PrePersist // every time a user entity is saved, where the createdAt is null, then
    // rather thn throwing exception, LocalDateTime.now will populate createdAt.
    // PrePersist means before the user is stored in the database
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
