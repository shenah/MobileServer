package naver.shen_aihua0126.MobileServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import naver.shen_aihua0126.MobileServer.domain.Reviews;
import naver.shen_aihua0126.MobileServer.service.ReviewsService;

@RestController
//@RestController 사용할 때 spring 버전이 4.0이상 인지 
//jackson-databind 라이브러리가 포함되어 있는지 확인 
public class ReviewsController {

	@Autowired
	private ReviewsService reviewsService;
	// 영화별 댓글 추가
	@RequestMapping(value="reviews/addreview", method = RequestMethod.POST)
	public Map<String, Object> addReview(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		int result = reviewsService.addReview(request);
		if(result == 1) {
			map.put("addreview", "success");
		}
		return map;
	}
	
	// 영화별 댓글 가져오기
	@RequestMapping(value="reviews/reviewlist", method = RequestMethod.GET)
	public Map<String, Object> reviewList(@RequestParam("movieId") int movieId){
		return reviewsService.reviewList(movieId);
	}
	
	//내 댓글 가져오기
	@RequestMapping(value="reviews/myreviews", method = RequestMethod.GET)
	public Map<String, Object> myreviews(@RequestParam("id") String memberId){		
		return reviewsService.myreviews(memberId);
	}
	
	// 내 댓글을 삭제하기
	@RequestMapping(value="reviews/deletereview", method = RequestMethod.DELETE)
	public Map<String, Object> deleteReview(@RequestParam("rno") int rno) {
		Map<String, Object> map = new HashMap<>();
		int result = reviewsService.deleteReview(rno);
		if(result == 1) {
			map.put("deletereview", "success");
		}
		return map;
	}

	// 좋아요 개수 증가
	@RequestMapping(value="reviews/like", method=RequestMethod.POST)
	public Map<String, Object> like(@RequestParam("rno") int rno){
		Map<String, Object> map = new HashMap<>();
		int result = reviewsService.like(rno);
		if(result == 1) {
			map.put("like", "success");
		}
		return map;
	}
}
