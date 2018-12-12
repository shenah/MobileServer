package naver.shen_aihua0126.MobileServer.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.shen_aihua0126.MobileServer.dao.ReviewsDao;
import naver.shen_aihua0126.MobileServer.domain.Reviews;

@Service
public class ReviewsServiceImpl implements ReviewsService {

	@Autowired
	private ReviewsDao reviewsDao;
	
	@Override
	public int addReview(HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String movieTitle = request.getParameter("movieTitle");
		String content = request.getParameter("content");
		
		Reviews review = new Reviews();
		review.setContent(content);
		review.setMovieTitle(movieTitle);
		review.setMovieId(movieId);
		review.setMemberId(memberId);
				
		return reviewsDao.addReview(review);
	}

	//영화별 댓글 리스트와 개수 가져오기 
	@Override
	public Map<String,Object> reviewList(int movieId) {
		int reviewcount = reviewsDao.reviewcount(movieId);
		List<Reviews> list= reviewsDao.reviewList(movieId);
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);
		
		for(Reviews r : list) {
			if(today.equals(r.getRegdate().substring(0, 10))) {
				r.setDispdate(r.getRegdate().substring(11, 16));
			}else {
				r.setDispdate(r.getRegdate().substring(0, 10));
			}
		}

		Map<String,Object> map = new HashMap<>();
		map.put("count", reviewcount);
		map.put("reviews", list);
		return map;
	}

	//내 댓글 가져오기
	@Override
	public Map<String,Object> myreviews(String memberId) {
		List<Reviews> list = reviewsDao.myreviews(memberId);
		int count = reviewsDao.mycount(memberId);
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);
		
		for(Reviews r : list) {
			if(today.equals(r.getRegdate().substring(0, 10))) {
				r.setDispdate(r.getRegdate().substring(11, 16));
			}else {
				r.setDispdate(r.getRegdate().substring(0, 10));
			}
		}
		Map<String,Object> map = new HashMap<>();
		map.put("count", count);
		map.put("reviews", list);
		System.out.println(map);
		return map;
	}

	//내 댓글 삭제 
	@Override
	public int deleteReview(int rno) {
		return reviewsDao.deleteReview(rno);
	}

	// 좋아요 개수 증가 
	@Override
	public int like(int rno) {
		return reviewsDao.like(rno);
	}



}
