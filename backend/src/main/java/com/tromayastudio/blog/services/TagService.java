package com.tromayastudio.blog.services;

import com.tromayastudio.blog.domain.entities.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<Tag> getAllTags();
    List<Tag> createTags(Set<String> tagNames);

}
