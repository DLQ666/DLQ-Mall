package com.dlq.order.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.dlq.common.pojo.QIResult;
import com.dlq.common.util.CookieUtils;
import com.dlq.pojo.QioResult;
import com.dlq.sso.service.QioUserService;

public class LoginInterceptor implements HandlerInterceptor {

	
	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;
	@Value("${SSO_LOGIN_URL}")
	private String SSO_LOGIN_URL;
	@Autowired
	private QioUserService qioUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 执行Handler之前执行此方法
		// a)从cookie中取token。
		String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
		if (StringUtils.isBlank(token)) {
			// 取当前请求的url
			String url = request.getRequestURL().toString();
			// b)没有token，需要跳转到登录页面。
			response.sendRedirect(SSO_LOGIN_URL +"/page/login?redirectUrl=" + url);
			// 拦截
			return false;
		}
		// c)有token。调用sso系统的服务，根据token查询用户信息。
		QIResult result = qioUserService.getUserByToken(token);
		if (result.getStatus() != 200) {
			// d)如果查不到用户信息。用户登录已经过期。需要跳转到登录页面。
			// 取当前请求的url
			String url = request.getRequestURL().toString();
			// b)没有token，需要跳转到登录页面。
			response.sendRedirect(SSO_LOGIN_URL +"/page/login?redirectUrl=" + url);
			// 拦截
			return false;
		}
		// e)查询到用户信息。放行。
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
