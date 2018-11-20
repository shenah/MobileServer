package naver.shen_aihua0126.MobileServer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import naver.shen_aihua0126.MobileServer.dao.MovieDao;
import naver.shen_aihua0126.MobileServer.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;
	
	@Transactional
	@Override 
	public int movieUpdate(Movie movie) {
		return movieDao.movieUpdate(movie);
	}
	
	@Override
	public int movieDelete() {	
		return movieDao.movieDelete();
	}
	
	@Override
	public List<Movie> movieList(HttpServletRequest request) {
		String status = request.getParameter("status");
		return movieDao.movieList(status);
	}

	@Override
	public Movie movieDetail(HttpServletRequest request) {
		String movieId = request.getParameter("movieId");
		return movieDao.movieDetail(movieId);
	}

}
