package naver.shen_aihua0126.MobileServer.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.shen_aihua0126.MobileServer.domain.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int register(Member member) {
		return sqlSession.insert("member.register", member);
	}
	
	public Member login(String id){
		return sqlSession.selectOne("member.login", id);
	}
}
