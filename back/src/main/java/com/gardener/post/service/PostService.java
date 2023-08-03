package com.gardener.post.service;

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

	public Post findPost(int id) {
		return repository.selectByPost(id);
	}
}
