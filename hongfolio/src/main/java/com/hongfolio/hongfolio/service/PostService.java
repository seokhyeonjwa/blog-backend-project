package com.hongfolio.hongfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.hongfolio.hongfolio.model.Post;
import com.hongfolio.hongfolio.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("Post not found: " + id));
        
    }

    // 카테고리별 게시물 검색
    public List<Post> findPostsByCategory(String category) {
        return postRepository.findByCategory(category);
    }

    // ID와 카테고리를 기반으로 게시물 상세 검색
    public Optional<Post> findPostByIdAndCategory(Long id, String category) {
        return postRepository.findByIdAndCategory(id, category);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post updatedPost) {
        Post post = getPostById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setAuthor(updatedPost.getAuthor());
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
