package com.gardener.writer.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;
import com.gardener.post.dto.Post;
import com.gardener.writer.dto.Writer;
import com.gardener.writer.repository.WriterRepository;

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
	m= repository.selectByWriter(writerid);
	return m;
}
public List<Post> selectByWriterPost(int writerid) throws FindException {
	List<Post> WriterPost = new ArrayList<Post>();
	WriterPost = repository.selectByWriterPost(writerid);
	return WriterPost;
	}

public List<Member> subscribeWriter(String loginId) throws FindException {
	List<Member> SubscribeWriter = new ArrayList<Member>();
	SubscribeWriter = repository.subscribeWriter(loginId);
	return SubscribeWriter;
	}
public boolean cancelWriter(int writerId) {
	// TODO Auto-generated method stub
	return false;
}
}
