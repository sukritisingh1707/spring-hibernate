package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.csv.UploadFile;
import com.dao.FileUploadDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.*")
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {

	@Autowired
	@Bean(name = "fileUploadDao")
	public FileUploadDaoImpl getUserDao(SessionFactory sessionFactory) {
		return new FileUploadDaoImpl(sessionFactory);
	}

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		System.out.println("Web Pages founded");
		InternalResourceViewResolver isvr = new InternalResourceViewResolver();
		isvr.setPrefix("/WEB-INF/");
		isvr.setSuffix(".jsp");
		return isvr;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520); // 20MB
		multipartResolver.setMaxInMemorySize(1048576); // 1MB
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

	@Autowired

	@Bean(name = "sessionFactory")

	public SessionFactory getSessionFactory() {

		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.current_session_context_class", "thread");
		LocalSessionFactoryBuilder localSessionFactoryBuider = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuider.addAnnotatedClass(UploadFile.class);

		localSessionFactoryBuider.addProperties(properties);
		SessionFactory sessionFactory =localSessionFactoryBuider.buildSessionFactory();
		return sessionFactory;
	}
}
