package com.codemong.jpa.lab.dto;

public record PostListItemResponse(Long postId, String title, String authorNickname, long commentCount) {
}
