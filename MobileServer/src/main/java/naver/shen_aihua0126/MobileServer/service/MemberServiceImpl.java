package naver.shen_aihua0126.MobileServer.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.shen_aihua0126.MobileServer.dao.MemberDao;
import naver.shen_aihua0126.MobileServer.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int register(MultipartHttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		MultipartFile image = request.getFile("image");
		
		//이미지 파일 실제경로 가져오기 
		String uploadPath = request.getRealPath("/memberimage");

		//저장할 파일 이름 만들기 
		UUID uid = UUID.randomUUID();
		String filename = image.getOriginalFilename();
		filename = uid + "_" + filename;
		
		//저장할 파일 경로 만들기 
		String filepath = uploadPath + "/" + filename;
		
		Member member = new Member();
		
		//파일 업로드 
		File file = new File(filepath);
		try {
			image.transferTo(file);
			member.setImage(filename);
			member.setId(id);
			member.setPw(BCrypt.hashpw(pw,BCrypt.gensalt()));
			member.setNickname(nickname);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return memberDao.register(member);
	}

	@Override
	public Member login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = memberDao.login(id);
		//selectOne은 데이터가 없으면 null 리턴 
		if(member != null) {
			if(BCrypt.checkpw(pw, member.getPw())) {
				member.setPw(null);
			}else {
				member = null;
			}
		}
		return member;
	}

}
