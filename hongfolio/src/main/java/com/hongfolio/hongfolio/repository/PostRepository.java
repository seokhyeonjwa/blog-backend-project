package com.hongfolio.hongfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hongfolio.hongfolio.model.Post;
import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {

    // 카테고리별 게시물 목록 검색
    List<Post> findByCategory(String category);

    // ID와 카테고리를 기반으로 게시물 상세 검색
    Optional<Post> findByIdAndCategory(Long id, String category);

}
