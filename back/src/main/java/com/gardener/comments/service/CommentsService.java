package com.gardener.comments.service;

import java.util.List;

import com.gardener.comments.dto.Comments;
import com.gardener.comments.repository.CommentsRepository;
import com.gardener.util.PageBean;

public class CommentsService {
	static private CommentsService service = new CommentsService();
	private CommentsRepository repository;

	private CommentsService() {
		repository = new CommentsRepository();
	}

	static public CommentsService getInstance() {
		return service;
	}

	public void saveReply(Comments comments) {
		repository.insertReply(comments);
	}

	public PageBean<Comments> findAll(int currentPage, int num) {
		int cntPerPage = 5;
		int endRow = currentPage * cntPerPage; // 5 10 15
		System.out.println(endRow + " -- service endRow");
		int startRow = endRow - cntPerPage + 1; // 1, 6, 11
		System.out.println(startRow + " -- service startRow");
		List<Comments> list = repository.selectAll(startRow, endRow, num);
		int totalCnt = repository.count(num);

		int cntPerPageGroup = 5;
		PageBean<Comments> pb = new PageBean(cntPerPage, totalCnt, list, cntPerPageGroup, currentPage);
		return pb;
	}

	public int count(int num) {
		return repository.count(num);

	}
}
