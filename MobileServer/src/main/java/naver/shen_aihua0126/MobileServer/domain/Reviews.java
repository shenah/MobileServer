package naver.shen_aihua0126.MobileServer.domain;

public class Reviews {

	private int rno;
	private String memberId;
	private int movieId;
	private String movieTitle;
	private String content;
	private String regdate;
	private int likecnt;
	private String dispdate;
	private String nickname;
	private String image;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	public String getDispdate() {
		return dispdate;
	}
	public void setDispdate(String dispdate) {
		this.dispdate = dispdate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Reviews [rno=" + rno + ", memberId=" + memberId + ", movieId=" + movieId + ", movieTitle=" + movieTitle
				+ ", content=" + content + ", regdate=" + regdate + ", likecnt=" + likecnt + ", dispdate=" + dispdate
				+ ", nickname=" + nickname + ", image=" + image + "]";
	}
	
}
