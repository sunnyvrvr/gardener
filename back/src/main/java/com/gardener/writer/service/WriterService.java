package com.gardener.writer.service;

import com.gardener.writer.respository.WriterRepository;

public class WriterService {

	static private WriterService service = new WriterService();
	private WriterRepository repository;

	private WriterService() {
		repository = new WriterRepository();
	}

	public static WriterService getInstance() {
		return service;
	}

	public boolean insertWriter(int id) {
		return repository.insertWriter(id);

	}

	public boolean cancelWriter(int id) {
		// boolean t = repository.cancelWriter(id);
		// System.out.println("넘어온 boolean = " + t);
		return repository.cancelWriter(id);
	}

	

}
