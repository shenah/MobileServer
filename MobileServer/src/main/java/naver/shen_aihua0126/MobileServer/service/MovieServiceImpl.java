package naver.shen_aihua0126.MobileServer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.shen_aihua0126.MobileServer.dao.MovieDao;
import naver.shen_aihua0126.MobileServer.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;
		
	@Override
	public List<Movie> movieList(HttpServletRequest request) {
		
		return null;
	}

	@Override
	public Movie movieDetail(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
