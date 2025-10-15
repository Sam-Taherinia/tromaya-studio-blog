package com.tromayastudio.blog.domain.dtos;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private UUID id;
    private String name;
    private long postCount;

}
