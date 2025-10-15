package com.tromayastudio.blog.repositories;

import com.tromayastudio.blog.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> { // we used JpaRepository because it gives us all that CRUD behavior and some pagination as well

}
