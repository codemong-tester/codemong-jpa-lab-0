package com.codemong.jpa.lab.controller;

            import com.codemong.jpa.lab.dto.PostDetailResponse;
import com.codemong.jpa.lab.dto.PostListItemResponse;
import com.codemong.jpa.lab.dto.PostPageResponse;
import org.springframework.web.bind.annotation.RequestParam;
            import com.codemong.jpa.lab.service.PostService;
            import lombok.RequiredArgsConstructor;
            import org.springframework.web.bind.annotation.GetMapping;
            import org.springframework.web.bind.annotation.PathVariable;
            import org.springframework.web.bind.annotation.RequestMapping;
            import org.springframework.web.bind.annotation.RestController;

            @RestController
            @RequiredArgsConstructor
            @RequestMapping("/api/posts")
            public class PostController {
                private final PostService postService;

                @GetMapping("/{postId}")
                public PostDetailResponse getPost(@PathVariable Long postId) {
                    return postService.getPost(postId);
                }

                @GetMapping
                public PostPageResponse<PostListItemResponse> getPosts(
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size
                ) {
                    return postService.getPosts(page, size);
                }
            }
