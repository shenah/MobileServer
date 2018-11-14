package naver.shen_aihua0126.MobileServer.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApplicationListener implements ServletContextListener {

	// 웹 애플리케이션이 시작될 때 호출되는 메소드
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// 현재 상영중 영화정보 
		try {
			// 다운로드 받을 URL 생성
			URL url = new URL(
					"https://api.themoviedb.org/3/movie/now_playing?api_key=0d18b9a2449f2b69a2489e88dd795d91&language=ko-KR&page=1");
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
			//System.out.println(movies);
			
			// 배열을 순회
			int i = 0;
			while (i < movies.length()) {
				JSONObject movie = movies.getJSONObject(i);
			
				int movieId = movie.getInt("id");
				double voteAverage = movie.getDouble("vote_average");
				String title = movie.getString("title");
				String posterPath = movie.getString("poster_path");
				String language = movie.getString("original_language");
				String originalTitle = movie.getString("original_title");
				Boolean adult = movie.getBoolean("adult");
				String overview = movie.getString("overview");
				String releaseDate = movie.getString("release_date");
				System.out.println(movieId + "  " + voteAverage + "  " + title + "  " + posterPath + "  " + language + "  " + originalTitle + "  " + adult + "  " + releaseDate);
				i = i + 1;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	// 웹 애플리케이션이 종료될 때 호출되는 메소드
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
