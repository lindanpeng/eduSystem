package interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private List<String> allowedPass;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String url=request.getRequestURL().toString();
        Object user=request.getSession().getAttribute("user");
        if(user!=null)
        	return true;
        for(String temp:allowedPass){
        	if(url.endsWith(temp))
        		return true;
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");
		return false;
	}

	public void setAllowedPass(List<String> allowedPass) {
		this.allowedPass = allowedPass;
	}
}
