package com.codemong.jpa.lab.service;

import com.codemong.jpa.lab.domain.Post;
import com.codemong.jpa.lab.dto.PostDetailResponse;
import com.codemong.jpa.lab.dto.PostListItemResponse;
import com.codemong.jpa.lab.dto.PostPageResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.codemong.jpa.lab.exception.PostNotFoundException;
import com.codemong.jpa.lab.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostDetailResponse getPost(Long postId) {
        Post post = postRepository.findDetailById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
        return PostDetailResponse.from(post);
    }

    @Transactional(readOnly = true)
    public PostPageResponse<PostListItemResponse> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return PostPageResponse.from(postRepository.findPostList(pageable));
    }
}
