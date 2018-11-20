package naver.shen_aihua0126.MobileServer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import naver.shen_aihua0126.MobileServer.domain.Movie;

public interface MovieService {

	//업데이트
	public int movieUpdate(Movie movie);
	//영화 정보 모두 삭제
	public int movieDelete();

	//영화 목록 가져오기
	public List<Movie> movieList(HttpServletRequest request);
	
	//영화 상세보기 정보 가져오기 
	public Movie movieDetail(HttpServletRequest request);
}
