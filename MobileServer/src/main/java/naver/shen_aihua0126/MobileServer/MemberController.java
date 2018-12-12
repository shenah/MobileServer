package naver.shen_aihua0126.MobileServer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.shen_aihua0126.MobileServer.domain.Member;
import naver.shen_aihua0126.MobileServer.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="member/register", method = RequestMethod.POST)
	public Map<String, Object> register(MultipartHttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		int result = memberService.register(request);
		if(result == 1) {
			map.put("register", "success");
		}
		return map;
	}
	
	@RequestMapping(value="member/login", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		Member member = memberService.login(request);	
		if(member == null) {
			member = new Member();
			//클라이언트에서 id == "NULL"로 로그인 성공 확인 
			member.setId("NULL");
		}
		
		//결과 저장 
		map.put("member", member);
		return map;
	}
}
