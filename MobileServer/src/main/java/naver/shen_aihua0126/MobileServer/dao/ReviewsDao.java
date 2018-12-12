package naver.shen_aihua0126.MobileServer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.shen_aihua0126.MobileServer.domain.Reviews;

@Repository
public class ReviewsDao {

	@Autowired
	private SqlSession sqlSession;

	// 댓글 추가
	public int addReview(Reviews review) {
		return sqlSession.insert("reviews.addReview", review);
	}

	// 영화별 댓글 가져오기
	public List<Reviews> reviewList(int movieId) {
		return sqlSession.selectList("reviews.reviewlist", movieId);
	}

	// 영화별 댓글 개수 가져오기
	public int reviewcount(int movieId) {
		return sqlSession.selectOne("reviews.reviewcount", movieId);
	}

	// 내 댓글을 가져오기
	public List<Reviews> myreviews(String id) {
		return sqlSession.selectList("reviews.myreviews", id);
	}

	// 내 댓글 개수 가져오기
	public int mycount(String id) {
		return sqlSession.selectOne("reviews.mycount", id);
	}

	// 내 댓글을 삭제하기
	public int deleteReview(int rno) {
		return sqlSession.delete("reviews.deleteReview", rno);
	}

	// 좋아요 개수 증가
	public int like(int rno) {
		return sqlSession.update("reviews.like", rno);
	}

}
