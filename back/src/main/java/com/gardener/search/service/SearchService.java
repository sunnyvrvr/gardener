package com.gardener.search.service;

import java.util.ArrayList;
import java.util.List;

import com.gardener.exception.FindException;
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
	List<Search> searchResult = new ArrayList<Search>();
	
	
	public List<Search> selectTitle(String title) throws FindException {
		searchResult = repository.searchTitle(title);
		return searchResult;
	}
	
	public List<Search> selectName(String name) throws FindException {
		searchResult = repository.searchName(name);
		return searchResult;
	}
	
	public List<Search> selectContent(String content) throws FindException {
		searchResult = repository.searchContent(content);
		return searchResult;
	}
	
	public List<Search> selectAll() throws FindException{
		searchResult = repository.selectAll();
		return searchResult;
	}

}
