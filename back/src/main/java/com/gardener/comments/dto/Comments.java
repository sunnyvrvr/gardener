package com.gardener.comments.dto;

import com.gardener.member.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Comments {
	private int id; // pk
	private int postId; // fk
	private int memberId; // fk
	private String content; // 600자까지
	private String createDate;
	private int report; // 좋아요 신고 수??

	private Member member; // 댓글을 쓴 사람

	public Comments(int id, int postId, int memberId, String content, String createDate, int report) {
		this.id = id;
		this.postId = postId;
		this.memberId = memberId;
		this.content = content;
		this.createDate = createDate;
		this.report = report;
	}
}
