package com.gardener.post.service;

<<<<<<< HEAD
public class PostService {

=======
import com.gardener.post.dto.Post;
import com.gardener.post.repository.PostRepository;

public class PostService {
	private static PostService service = new PostService();
	private PostRepository repository;
	public PostService() {
		repository = new PostRepository();
	}
	public static PostService getInstance() {
		return service;
	}
	public Post selectById(String loginid) {
		Post p = new Post();
		repository.selectById(loginid);
		return p;
	}
>>>>>>> origin
}
