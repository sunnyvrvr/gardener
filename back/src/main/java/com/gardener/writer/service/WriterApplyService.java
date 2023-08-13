package com.gardener.writer.service;

import com.gardener.writer.repository.WriterApplyRepository;

public class WriterApplyService {

	static private WriterApplyService service = new WriterApplyService();
	private WriterApplyRepository repository;

	private WriterApplyService() {
		repository = new WriterApplyRepository();
	}

	public static WriterApplyService getInstance() {
		return service;
	}

	public boolean insertWriter(int memberId) {
	    return repository.insertWriter(memberId);
	  }

	public boolean cancelWriter(int id) {
		// boolean t = repository.cancelWriter(id);
		// System.out.println("넘어온 boolean = " + t);
		return repository.cancelWriter(id);
	}

	public int getIdByLoginId(String loginId) {
		
		return 0;
	}

	

}
