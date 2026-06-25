package com.codemong.jpa.lab.repository;

import com.codemong.jpa.lab.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
