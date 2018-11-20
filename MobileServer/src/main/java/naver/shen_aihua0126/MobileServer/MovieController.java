package naver.shen_aihua0126.MobileServer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import naver.shen_aihua0126.MobileServer.domain.Movie;
import naver.shen_aihua0126.MobileServer.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	

	@RequestMapping(value = {"movie/now_playing","movie/upcoming", "movie/top_rated"}, method = RequestMethod.GET)
	public List<Movie> movieList(HttpServletRequest request){
		
		return movieService.movieList(request);
	}
	
	@RequestMapping(value = {"movie/detail"}, method = RequestMethod.GET)
	public Movie movieDetail(HttpServletRequest request){
		
		return movieService.movieDetail(request);
	}

	
}
