package com.app.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.app.util.Util;
import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@EnableTransactionManagement
public abstract class AbstractDaoImpl {
	public static String url = Util.getProperty("database.properties", "datasource.url");
	public static String user = Util.getProperty("database.properties", "datasource.user");
	public static String password = Util.getProperty("database.properties", "datasource.password");
	
	protected static JdbcTemplate jdbcTemplate;
	protected static MysqlDataSource ds = null;
	
	public AbstractDaoImpl() {
		ds = new MysqlDataSource();
		ds.setUrl(url);
		ds.setUser(user);
		ds.setPassword(password);
		jdbcTemplate = new JdbcTemplate(ds);
	}
}
