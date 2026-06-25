-- Local seed data for manual API testing. Hidden tests create their own data.
-- Members are reused across posts so lazy author loading and fetch join behavior are easy to observe.
insert into member (id, email, nickname) values (1, 'mongo@example.com', 'mongo');
insert into member (id, email, nickname) values (2, 'neo@example.com', 'neo');
insert into member (id, email, nickname) values (3, 'river@example.com', 'river');
insert into member (id, email, nickname) values (4, 'querybot@example.com', 'querybot');

-- Posts are ordered by created_at so GET /api/posts?page=0&size=... should return higher ids first.
insert into post (id, title, content, member_id, created_at, updated_at) values (1, 'Step01 Member-Post 매핑', 'Post가 작성자 Member를 LAZY N:1로 참조하는지 확인합니다.', 1, timestamp '2026-01-01 10:00:00', timestamp '2026-01-01 10:00:00');
insert into post (id, title, content, member_id, created_at, updated_at) values (2, 'Step02 Comment 연관관계', 'Comment가 Post와 Member를 참조하고 Post.comments 컬렉션을 가집니다.', 2, timestamp '2026-01-02 10:00:00', timestamp '2026-01-02 10:00:00');
insert into post (id, title, content, member_id, created_at, updated_at) values (3, 'Step03 상세 조회 DTO', '게시글 상세 API에서 작성자와 댓글 목록을 DTO로 반환합니다.', 3, timestamp '2026-01-03 10:00:00', timestamp '2026-01-03 10:00:00');
insert into post (id, title, content, member_id, created_at, updated_at) values (4, 'Step04 목록 페이징', '목록 API에서 page와 size, 최신순 정렬, commentCount를 확인합니다.', 1, timestamp '2026-01-04 10:00:00', timestamp '2026-01-04 10:00:00');
insert into post (id, title, content, member_id, created_at, updated_at) values (5, 'Step05 작성자 N+1 확인', '목록 조회에서 여러 작성자 nickname을 접근할 때 추가 쿼리를 관찰합니다.', 2, timestamp '2026-01-05 10:00:00', timestamp '2026-01-05 10:00:00');
insert into post (id, title, content, member_id, created_at, updated_at) values (6, 'Step06 컬렉션 Fetch Join 페이징', '댓글 컬렉션 fetch join과 페이징을 함께 사용할 때의 문제를 확인합니다.', 3, timestamp '2026-01-06 10:00:00', timestamp '2026-01-06 10:00:00');
insert into post (id, title, content, member_id, created_at, updated_at) values (7, 'Step07 DTO Projection 조회', '목록 조회에서 필요한 필드만 select하는 DTO Projection 구조를 확인합니다.', 4, timestamp '2026-01-07 10:00:00', timestamp '2026-01-07 10:00:00');

-- Comment counts are intentionally different by post for list commentCount checks.
insert into comment (id, content, post_id, member_id, created_at) values (1, '연관관계 매핑을 먼저 완성하세요.', 2, 1, timestamp '2026-01-02 11:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (2, '상세 조회 응답에 포함되는 댓글입니다.', 3, 1, timestamp '2026-01-03 11:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (3, '댓글 작성자 nickname도 함께 내려와야 합니다.', 3, 2, timestamp '2026-01-03 12:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (4, '목록에서는 댓글 본문을 로딩하지 않는 것이 좋습니다.', 4, 3, timestamp '2026-01-04 11:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (5, '작성자 N+1을 로그로 확인해보세요.', 5, 1, timestamp '2026-01-05 11:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (6, 'EntityGraph 또는 fetch join을 비교해보세요.', 5, 4, timestamp '2026-01-05 12:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (7, '컬렉션 fetch join과 Pageable 조합은 주의가 필요합니다.', 6, 1, timestamp '2026-01-06 11:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (8, 'Hibernate 경고나 예외를 확인해보세요.', 6, 2, timestamp '2026-01-06 12:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (9, '목록 API와 상세 API의 책임을 분리하세요.', 6, 3, timestamp '2026-01-06 13:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (10, 'DTO Projection은 필요한 컬럼만 조회합니다.', 7, 1, timestamp '2026-01-07 11:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (11, '응답 모델과 Entity 모델을 분리하세요.', 7, 2, timestamp '2026-01-07 12:00:00');
insert into comment (id, content, post_id, member_id, created_at) values (12, '목록에서는 postId, title, authorNickname, commentCount만 확인합니다.', 7, 3, timestamp '2026-01-07 13:00:00');
