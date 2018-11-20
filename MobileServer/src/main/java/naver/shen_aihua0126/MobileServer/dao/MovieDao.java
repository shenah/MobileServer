package naver.shen_aihua0126.MobileServer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.shen_aihua0126.MobileServer.domain.Movie;

@Repository
public class MovieDao {

	@Autowired
	private SqlSession sqlSession;
	
	//서버 실행시 업데이트 메소드 
	public int movieUpdate(Movie movie){
		return sqlSession.insert("movie.update", movie);
	}
	public int movieDelete() {
		return sqlSession.delete("movie.movieDelete");
	}
	
	//영화 목록 가져오기 
	public List<Movie> movieList(String status) {
		return sqlSession.selectList("movie.movieList", status);
	}
	
	//영화 상세보기 정보 가져오기 
	public Movie movieDetail(String movieId) {
		return sqlSession.selectOne("movie.movieDetail", movieId);
	}
	
}
