package naver.shen_aihua0126.MobileServer.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import naver.shen_aihua0126.MobileServer.dao.MovieDao;
import naver.shen_aihua0126.MobileServer.domain.Movie;

@Component
public class ApplicationListener  {

	@Autowired
	private MovieDao movieDao;

	public MovieDao getMovieDao() {
		return movieDao;
	}

	//@PostConstruct
	public void initialize(){
		
		System.out.println(movieDao);
		
		// 현재 상영중 영화정보
		// Thread th = new Thread(){
		// public void run() {

		try {
			//
			// Thread.sleep(86400000);

			// 다운로드 받을 URL 생성
			URL url = new URL(
					"https://api.themoviedb.org/3/movie/now_playing?api_key=0d18b9a2449f2b69a2489e88dd795d91&language=ko-KR&page=1&region=KR");
			// URL 연결 객체 생성
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 옵션설정
			// 캐시 설정 여부 - 다운로드 받아놓고 다음에 다운로드 받은 데이터를 이용할 것인지 여부 설정
			con.setUseCaches(false);
			// 얼마동안 접속을 시도해 볼것인지 설정
			con.setConnectTimeout(30000);
			// 문자열을 읽기 위한 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			// 줄 단위로 데이터를 읽어서 sb에 추가
			StringBuilder sb = new StringBuilder();
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				sb.append(line);
			}
			// sb의 내용을 json에 대입
			String json = sb.toString();

			// 메모리 스트림 정리
			sb = null;
			br.close();
			con.disconnect();

			// JSON 문자열 파싱 -JSONObject
			JSONObject jso = new JSONObject(json);

			JSONArray movies = jso.getJSONArray("results");
			// System.out.println(movies);

			// 배열을 순회
			int i = 0;
			Movie m = null;

			while (i < movies.length()) {

				JSONObject movie = movies.getJSONObject(i);
				String overview = movie.getString("overview");

				if (overview.length() == 0) {
					i = i + 1;
					return;
				}

				int movieId = movie.getInt("id");
				double voteAverage = movie.getDouble("vote_average");
				String title = movie.getString("title");
				String posterPath = movie.getString("poster_path");
				String backdropPath = movie.get("backdrop_path").toString();
				String originalLanguage = movie.getString("original_language");
				String originalTitle = movie.getString("original_title");
				String adult = "";
				// Boolean Type 변경
				if (movie.getBoolean("adult") == false) {
					adult = "청가";
				} else {
					adult = "청불";
				}
				String releaseDate = movie.getString("release_date");
				String status = "now_playing";

				m = new Movie();

				m.setMovieId(movieId);
				m.setVoteAverage(voteAverage);
				m.setTitle(title);
				m.setPosterPath(posterPath);
				m.setBackdropPath(backdropPath);
				m.setOverview(overview);
				m.setOriginalLanguage(originalLanguage);
				m.setOriginalTitle(originalTitle);
				m.setAdult(adult);
				m.setReleaseDate(releaseDate);
				m.setStatus(status);
				System.out.println(m);
				int result = movieDao.update(m);
				System.out.println(result);
				i = i + 1;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	


}
