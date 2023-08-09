package com.gardener.post.service;

import java.util.List;
import java.util.Optional;

import com.gardener.post.dto.Post;
import com.gardener.post.repository.PostRepository;

public class PostService {
	static private PostService service = new PostService();
	private PostRepository repository;

	private PostService() {
		repository = new PostRepository();
	}

	public static PostService getInstance() {
		return service;
	}

	public void savePost(Post post) {
		repository.insertPost(post);
	}

	public void saveImg(String[] imgs) {
		repository.insertImgs(imgs);
	}

	public Optional<Post> findPost(int id) {
		Optional<Post> post = repository.selectById(id);
		return post;
	}

	public List<Post> findAllPosts() {
		return repository.selectAllPosts();
	}

	public void updatePost(Post post) {
		repository.updatePost(post);
	}
}
