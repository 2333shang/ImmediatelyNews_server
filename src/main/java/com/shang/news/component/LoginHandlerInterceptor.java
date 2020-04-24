package com.shang.news.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String loginuser = (String) request.getSession().getAttribute("login_user");
		if(StringUtils.isEmpty(loginuser)) {
			request.setAttribute("msg", "没有权限，请先登陆！");
			request.getRequestDispatcher("/user/logininvalid").forward(request, response);
			return false;
		}else {
			return true;
		}
	}
}
