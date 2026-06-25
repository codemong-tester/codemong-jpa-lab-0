package com.codemong.jpa.lab.repository;

            import com.codemong.jpa.lab.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import com.codemong.jpa.lab.dto.PostListItemResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

            public interface PostRepository extends JpaRepository<Post, Long> {

                @EntityGraph(attributePaths = {"member", "comments", "comments.member"})
                Optional<Post> findDetailById(Long id);

                @EntityGraph(attributePaths = "member")
                Page<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);

                @Query(value = "select new com.codemong.jpa.lab.dto.PostListItemResponse(p.id, p.title, m.nickname, count(c.id)) " +
                       "from Post p join p.member m left join p.comments c " +
                       "group by p.id, p.title, m.nickname, p.createdAt " +
                       "order by p.createdAt desc",
                       countQuery = "select count(p) from Post p")
                Page<PostListItemResponse> findPostList(Pageable pageable);
            }
