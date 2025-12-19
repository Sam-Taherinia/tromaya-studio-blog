package com.tromayastudio.blog.services.impl;

import com.tromayastudio.blog.domain.entities.Tag;
import com.tromayastudio.blog.repositories.TagRepository;
import com.tromayastudio.blog.services.TagService;
import org.springframework.transaction.annotation.Transactional;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    @Override
    @Transactional (readOnly = true)
    public List<Tag> getAllTags() {
        return tagRepository.findAllWithPostCount();
    }
}
