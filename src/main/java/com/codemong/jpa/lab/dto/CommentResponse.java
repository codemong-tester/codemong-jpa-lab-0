package com.codemong.jpa.lab.dto;

import com.codemong.jpa.lab.domain.Comment;

public record CommentResponse(Long commentId, String content, String authorNickname) {
    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContent(), comment.getMember().getNickname());
    }
}
