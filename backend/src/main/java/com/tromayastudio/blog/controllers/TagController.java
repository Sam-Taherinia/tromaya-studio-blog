package com.tromayastudio.blog.controllers;

import com.tromayastudio.blog.domain.dtos.TagResponse;
import com.tromayastudio.blog.domain.entities.Tag;
import com.tromayastudio.blog.mappers.TagMapper;
import com.tromayastudio.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        List<TagResponse> tagResponses = tags.stream().map(tagMapper::toTagResponse).toList();
        return ResponseEntity.ok(tagResponses);
    }
}
