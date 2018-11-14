package naver.shen_aihua0126.MobileServer;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MovieTest {

	@Autowired 
	private DataSource ds;
	
	@Test
	public void connectTest() throws Exception {
		Connection con = null;
		try {
			con = ds.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			if(con != null) {
				con.close();
			}
		}
		
	}
}
