package com.company.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CompanyLoggingInterceptor 
implements HandlerInterceptor {
	
	private static final Logger LOG = Logger.getLogger(CompanyLoggingInterceptor.class);
	private long 	preHandleTimeInMs = 0,
					postHandleTimeInMs = 0,
					afterCompletionTimeInMs = 0;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		preHandleTimeInMs = System.currentTimeMillis();
		
		LOG.info("Before calling method in controller");
		LOG.info(prepareLogDataFromRequest(request));
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		postHandleTimeInMs = System.currentTimeMillis();
		
		LOG.info("After execution of controller method, before generating a view");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		afterCompletionTimeInMs = System.currentTimeMillis();
		
		LOG.info("After generating a view");
		LOG.info("Handler execution time :\t" + (postHandleTimeInMs - preHandleTimeInMs));
		LOG.info("Total time :\t" + (afterCompletionTimeInMs - preHandleTimeInMs));
		
		if(ex != null){
			LOG.info("An exception has occured");
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			
			LOG.info("Stack trace :\n" + sw.toString());
		}
	}
	
	private String prepareLogDataFromRequest(HttpServletRequest request){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\tServlet context path :\t" + request.getContextPath() + "\n");
		sb.append("\tServlet path :\t" + request.getServletPath() + "\n");
		sb.append("\tLocal address :\t" + request.getLocalAddr() + "\n");
		sb.append("\tRemote address :\t" + request.getRemoteAddr() + "\n");
		sb.append("\tMethod :\t" + request.getMethod() + "\n");
		sb.append("\tQuery string :\t" + request.getQueryString() + "\n");
		sb.append("\tRequest URI :\t" + request.getRequestURI() + "\n");
		
		return sb.toString();
	}

}
