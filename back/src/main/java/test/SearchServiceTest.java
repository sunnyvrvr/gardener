package test;

import java.util.ArrayList;
import java.util.List;

import com.gardener.exception.FindException;
import com.gardener.post.dto.Post;
import com.gardener.post.service.PostService;
import com.gardener.search.dto.Search;
import com.gardener.search.repository.SearchRepository;

public class SearchServiceTest {
	private static SearchServiceTest service = new SearchServiceTest();
	private SearchRepository repository;
	
	public SearchServiceTest() {
		repository = new SearchRepository();
	}
	
	public static SearchServiceTest getInstance() {
		return service;
	}
	
	public List<Search> selectTitle(String title) throws FindException {
		List<Search> selectTitle = new ArrayList<Search>();
		selectTitle = repository.searchTitle(title);
		return selectTitle;
	}
	
	public List<Search> selectName(String name) throws FindException {
		List<Search> selectName = new ArrayList<Search>();
		selectName = repository.searchName(name);
		return selectName;
	}
	
	public List<Search> selectContent(String content) throws FindException {
		List<Search> selectContent = new ArrayList<Search>();
		selectContent = repository.searchContent(content);
		return selectContent;
	}
	
}
