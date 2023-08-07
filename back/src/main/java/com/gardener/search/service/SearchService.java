package com.gardener.search.service;

import java.util.ArrayList;
import java.util.List;

import com.gardener.exception.FindException;
import com.gardener.post.dto.Post;
import com.gardener.post.service.PostService;
import com.gardener.search.dto.Search;
import com.gardener.search.repository.SearchRepository;

public class SearchService {
	private static SearchService service = new SearchService();
	private SearchRepository repository;
	
	public SearchService() {
		repository = new SearchRepository();
	}
	
	public static SearchService getInstance() {
		return service;
	}
	
	//repository에서 넘어올 리스트를 받는 변수
	List<Search> searchText = new ArrayList<Search>();
	
	
	public List<Search> selectTitle(String searchTitle) throws FindException {
		searchText = repository.searchTitle(searchTitle);
		return searchText;
	}
	
	public List<Search> selectName(String searchName) throws FindException {
		searchText = repository.searchName(searchName);
		return searchText;
	}
	
	public List<Search> selectContent(String searchContent) throws FindException {
		searchText = repository.searchContent(searchContent);
		return searchText;
	}
	
}
