package com.codemong.jpa.lab.dto;

import com.codemong.jpa.lab.domain.Post;
import java.util.List;

public record PostDetailResponse(
        Long postId,
        String title,
        String content,
        String authorNickname,
        List<CommentResponse> comments
) {
    public static PostDetailResponse from(Post post) {
        return new PostDetailResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getMember().getNickname(),
                post.getComments().stream().map(CommentResponse::from).toList()
        );
    }
}
