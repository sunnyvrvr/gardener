package com.gardener.post.service;

<<<<<<< HEAD
<<<<<<< HEAD
public class PostService {

=======
=======
>>>>>>> 0d53565f9944c2b41e90e1f5d3023e3a9414b2b7
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
<<<<<<< HEAD
>>>>>>> origin
=======
=======
public class PostService {

>>>>>>> ca6ce0378bd2e378480644d4496b70b73bf43b04
>>>>>>> 0d53565f9944c2b41e90e1f5d3023e3a9414b2b7
}
