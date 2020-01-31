package com.cillianbird.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cillianbird.util.ControllerUtility;


public class LogInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		boolean proceedFlag = true;
		
		// Add local thread info to logging context
		ThreadContext.put("SESSIONID", request.getSession().getId());
		ThreadContext.put("IPADDRESS", ControllerUtility.remoteAddr(request));
		
		return proceedFlag;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {

	}
}

