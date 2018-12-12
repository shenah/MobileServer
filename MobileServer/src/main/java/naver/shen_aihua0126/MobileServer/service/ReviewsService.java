package naver.shen_aihua0126.MobileServer.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import naver.shen_aihua0126.MobileServer.domain.Reviews;

public interface ReviewsService {

	public int addReview(HttpServletRequest request);

	// 영화별 댓글 가져오기
	public Map<String,Object> reviewList(int movieId);

	// 내 댓글을 가져오기
	public Map<String,Object> myreviews(String id);

	// 내 댓글을 삭제하기
	public int deleteReview(int rno);

	// 좋아요 개수 증가
	public int like(int rno);
}
