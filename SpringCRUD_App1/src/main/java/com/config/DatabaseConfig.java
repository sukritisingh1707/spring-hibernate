package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bean.Emp;
import com.dao.EmpDao;
import com.dao.EmpDaoImpl;

@Configuration
@ComponentScan("com.*")
@EnableTransactionManagement
public class DatabaseConfig {

	private static final String DATABASE_DRIVER_CLASS="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_URL="jdbc:sqlserver://DESKTOP-FQJMKES\\SQLEXPRESS:1433;databaseName=niit";
	private static final String DATABASE_USER="sa";
	private static final String DATABASE_PASSWORD="123";
	private static final String HBMDDL="update";
	private static final String HIBERNATE_DIALECT="org.hibernate.dialect.SQLServerDialect";
	
	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER_CLASS);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASSWORD);
		System.out.println("Oracle connected");
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", HBMDDL);
		properties.put("hibernate.dialect",HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		LocalSessionFactoryBuilder localSessionFactoryBuider = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuider.addProperties(properties);
		
		localSessionFactoryBuider.addAnnotatedClass(Emp.class);
		System.out.println("=== Tables Created ===");
		SessionFactory sessionFectory = localSessionFactoryBuider.buildSessionFactory(); 
		
		return sessionFectory;
		
	}
	
	@Bean("empDao")
	public EmpDao getEmpDao() {
		return new EmpDaoImpl();
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		
		return new HibernateTransactionManager(sessionFactory);
	}
}
