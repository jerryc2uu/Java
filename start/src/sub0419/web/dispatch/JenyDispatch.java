package sub0419.web.dispatch;

import sub0419.web.controller.member.HttpServletReponse;
import sub0419.web.controller.member.HttpServletRequest;
import sub0419.web.controller.*;
import sub0419.web.controller.member.*;
import java.util.*;

//*.jeny
public class JenyDispatch extends HttpServlet {
	
	private HashMap<String, MainController> map = new HashMap<String, MainController>();
	
	public void init() {
		map.put("/main.jeny", new JenyMain());
		map.put("/member/login.jeny", new Login());
	}
	
	public String service(HttpServletRequest req, HttpServletReponse resp) {
		MainController main1 = map.get("/main.jeny");
		main1.exec(req, resp);
		
		MainController main2 = map.get("/member/login.jeny");
		main2.exec(req, resp);
	}
}
