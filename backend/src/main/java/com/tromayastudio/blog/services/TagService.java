package com.tromayastudio.blog.services;

import com.tromayastudio.blog.domain.entities.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTags();
}
