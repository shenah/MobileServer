package naver.shen_aihua0126.MobileServer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import naver.shen_aihua0126.MobileServer.domain.Movie;

public interface MovieService {

	//영화 목록 가져오기
	public List<Movie> movieList(HttpServletRequest request);
	
	//영화 상세보기 정보 가져오기 
	public Movie movieDetail(HttpServletRequest request);
}
