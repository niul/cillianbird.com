package com.cillianbird.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cillianbird.util.ControllerUtility;


public class LogInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {

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

