package com.tromayastudio.blog.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service // TODO
public interface AuthenticationService {

    UserDetails authenticate (String email, String password);
    String generateToken (UserDetails userDetails);
    UserDetails validateToken (String token);
}
