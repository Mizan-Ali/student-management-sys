//package com.management.student.utility;
//
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
////import org.apache.logging.log4j.LogManager;
////import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class LoggingAspect {
//	
////	private Logger logger = LogManager.getLogger(this.getClass());
//	
//	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
//	@AfterThrowing(pointcut = "execution(* com.management.student.service.*(..))", throwing = "exception")
//	public void logExceptionFromDAO(Exception exception) {
////		logger.error(exception.getMessage(), exception);
//		LOGGER.error(exception.getMessage(), exception);
//		
//	}
//	
//}
