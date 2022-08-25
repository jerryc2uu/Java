package sub0419.web.controller;

public interface MainController {
	
	public abstract String exec(HttpServletRequest req, HttpServletReponse resp); //어디서든 오버라이딩해야 하는 추상함수
}
