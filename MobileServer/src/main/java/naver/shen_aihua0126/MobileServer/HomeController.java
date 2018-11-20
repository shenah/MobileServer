package naver.shen_aihua0126.MobileServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.shen_aihua0126.MobileServer.domain.Movie;
import naver.shen_aihua0126.MobileServer.service.MovieService;

@Controller
public class HomeController {

	@Autowired
	private MovieService movieService;
	
	private static boolean swich = true;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		if (swich == true) {
			int re = movieService.movieDelete();
			System.out.println(re);
			String[] status = {
					"now_playing", "upcoming", "top_rated"};
			Thread th = new Thread() {
				public void run() {

					try {
						for (String s : status) {
							// 현재 상영중 영화정보 다운로드 받을 URL 생성
							URL url = new URL("https://api.themoviedb.org/3/movie/" + s +"?api_key=0d18b9a2449f2b69a2489e88dd795d91&language=ko-KR&region=KR");
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
								String status = s;

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
								int result = movieService.movieUpdate(m);
								System.out.print(result);
								i = i + 1;
							}
						}
						System.out.println("======================");
						swich = false;

					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
			};
			th.start();
		}
		return "home";
	}

}
