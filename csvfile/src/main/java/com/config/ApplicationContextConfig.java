package com.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.dao.FileUploadDao;
import com.dao.FileUploadDaoImpl;

public class ApplicationContextConfig {
	@Autowired
	@Bean(name = "fileUploadDao")
	public FileUploadDao getUserDao(SessionFactory sessionFactory) {
	    return new FileUploadDaoImpl(sessionFactory);
	}
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   // 20MB
	    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	    return multipartResolver;
	}
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    dataSource.setUrl("jdbc:sqlserver://DESKTOP-FQJMKES\\SQLEXPRESS:1433;databaseName=niit");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("123");
	 
	    return dataSource;
	}
}
