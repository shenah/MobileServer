package naver.shen_aihua0126.MobileServer;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.shen_aihua0126.MobileServer.dao.ReviewsDao;
import naver.shen_aihua0126.MobileServer.domain.Reviews;


@Controller
public class HomeController {


	@Autowired
	private ReviewsDao reviewsDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		
		return "home";
	}

}
