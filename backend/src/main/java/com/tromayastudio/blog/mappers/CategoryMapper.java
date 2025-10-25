package com.tromayastudio.blog.mappers;

import com.tromayastudio.blog.domain.PostStatus;
import com.tromayastudio.blog.domain.dtos.CategoryDto;
import com.tromayastudio.blog.domain.dtos.CreateCategoryRequest;
import com.tromayastudio.blog.domain.entities.Category;
import com.tromayastudio.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE) // so when it can't map properties to target, it ignores them and not throw exception
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (posts == null) {
            return 0;
        }
        return posts.stream().filter(post -> PostStatus.PUBLISHED.equals(post.getStatus())).count(); // STUDY
    }

}
