package com.dou.common.configuration;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dou.common.util.SpringContextHolder;


/**
 * 重写事务配置
 */
@Configuration
@EnableTransactionManagement
public class MyDataSourceTransactionManagerAutoConfiguration extends DataSourceTransactionManagerAutoConfiguration {
	private static final Logger log = LoggerFactory.getLogger(MyDataSourceTransactionManagerAutoConfiguration.class) ;
	
	/**
	 * 自定义事务
	 * MyBatis自动参与到spring事务管理中，无需额外配置，只要org.mybatis.spring.SqlSessionFactoryBean引用的数据源与DataSourceTransactionManager引用的数据源一致即可，否则事务管理会不起作用。
	 * @return
	 */
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManagers() {
		log.info("-------------------- transactionManager init ---------------------");
		return new DataSourceTransactionManager((DataSource) SpringContextHolder.getBean("roundRobinDataSouceProxy"));
	}
}
