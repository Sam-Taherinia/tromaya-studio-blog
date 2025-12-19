package com.tromayastudio.blog.services;

import com.tromayastudio.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID userId);
}
