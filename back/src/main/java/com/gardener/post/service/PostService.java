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

	public void updatePost(Post post) {
		repository.updatePost(post);
	}
}
