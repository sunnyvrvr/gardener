package com.gardener.writer.service;

import org.apache.ibatis.session.SqlSession;

import com.gardener.member.dto.Member;
import com.garderner.writer.dto.Writer;

import com.garderner.writer.repository.WriterRepository;

public class WriterService {
private static WriterService service= new WriterService();
private WriterRepository repository;
public WriterService() {
	repository = new WriterRepository();
}
public static WriterService getInstance() {
	return service;
}
public Member selectByWriter(int writerid) {
	Member m = new Member();
	repository.selectByWriter(writerid);
	return m;
}
}
