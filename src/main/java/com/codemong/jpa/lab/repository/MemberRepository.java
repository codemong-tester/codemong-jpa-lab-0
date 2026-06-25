package com.codemong.jpa.lab.repository;

import com.codemong.jpa.lab.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
