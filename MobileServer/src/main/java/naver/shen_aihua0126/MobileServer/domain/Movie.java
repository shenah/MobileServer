package naver.shen_aihua0126.MobileServer.domain;

public class Movie {

	private int movieId;
	private double voteAverage;
	private String title;
	private String posterPath; 
	private String backdropPath;
	private String originalLanguage;
	private String originalTitle;
	private String adult;
	private String overview;
	private String releaseDate;
	private String status = "now_playing";
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public double getVoteAverage() {
		return voteAverage;
	}
	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	public String getBackdropPath() {
		return backdropPath;
	}
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", voteAverage=" + voteAverage + ", title=" + title + ", posterPath="
				+ posterPath + ", backdropPath=" + backdropPath + ", originalLanguage=" + originalLanguage
				+ ", originalTitle=" + originalTitle + ", adult=" + adult + ", overview=" + overview + ", releaseDate="
				+ releaseDate + ", status=" + status + "]";
	}

	
}
