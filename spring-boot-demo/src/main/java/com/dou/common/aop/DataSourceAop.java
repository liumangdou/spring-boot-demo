package com.dou.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dou.common.datasource.DataSourceContextHolder;



/**
 * aop 拦截 进行切换数据源
 * 如果service层 增加了@Transactional ，导致数据源MyAbstractRoutingDataSource的determineCurrentLookupKey()方法会在执行DataSourceAop拦截之前就进行全局事务绑定
 * 从而导致获取 DataSourceContextHolder.getJdbcType(); 一直都是空值
 */
@Aspect
@Order(-1)
@Component
public class DataSourceAop {
	private static final Logger log = LoggerFactory.getLogger(DataSourceAop.class) ;
	
	@Before("execution(* com.dou.dao..*.find*(..)) or execution(* com.dou.dao..*.get*(..)) or execution(* com.dou.dao..*.select*(..))")
	public void setReadDataSourceType() {
		DataSourceContextHolder.read();
		log.info("dataSource切换到：Read");
	}
	
	/*@Around("@annotation(org.springframework.transaction.annotation.Transactional)")
	public void setWriteDataSourceType(ProceedingJoinPoint joinPoint) throws Throwable {
		Transactional datasource = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(Transactional.class);
		if(datasource.readOnly()){
			DataSourceContextHolder.read();
			log.info("dataSource切换到：Read");
		}else{
			DataSourceContextHolder.write();
			log.info("dataSource切换到：write");
		}
		joinPoint.proceed();
	}*/
}
