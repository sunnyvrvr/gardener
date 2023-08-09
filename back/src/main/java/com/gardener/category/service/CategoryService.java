package com.gardener.category.service;

import java.util.ArrayList;
import java.util.List;

import com.gardener.category.repository.CategoryRepository;
import com.gardener.exception.FindException;
import com.gardener.search.dto.Search;

public class CategoryService {
	private static CategoryService service = new CategoryService();
	private CategoryRepository repository;
	
	public CategoryService() {
		repository = new CategoryRepository();
	}
	
	public static CategoryService getInstance() {
		return service;
	}
	
	//硫����� ����
	public List<Search> selectCategory(String category) throws FindException {
		List<Search> categoryList = new ArrayList<>(); 
		categoryList = repository.selectCategory(category);
		return categoryList;
	}
}
