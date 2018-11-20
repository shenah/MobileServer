package naver.shen_aihua0126.MobileServer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.shen_aihua0126.MobileServer.domain.Member;

public interface MemberService {

	public int register(MultipartHttpServletRequest request);
	public Member login(HttpServletRequest request);
}
