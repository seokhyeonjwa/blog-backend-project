package com.hongfolio.hongfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hongfolio.hongfolio.model.Post;


public interface PostRepository extends JpaRepository<Post, Long> {

}
