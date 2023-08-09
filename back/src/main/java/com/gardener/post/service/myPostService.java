package com.gardener.post.service;


import java.util.ArrayList;
import java.util.List;

import com.gardener.exception.FindException;
import com.gardener.post.dto.Post;
import com.gardener.post.repository.myPostRepository;

public class myPostService {
	private static myPostService service = new myPostService();
	private myPostRepository repository;
	public myPostService() {
		repository = new myPostRepository();
	}
	public static myPostService getInstance() {
		return service;
	}
	public List<Post> selectById(String mainTitle) throws FindException {
		List<Post> listPost = new ArrayList<Post>();
		listPost = repository.selectById(mainTitle);
		return listPost;
	}
	public List<Post> selectByLoginid(String loginid) throws FindException {
		List<Post> listPost = new ArrayList<Post>();
		listPost = repository.selectByLoginid(loginid);
		return listPost;
	}

}