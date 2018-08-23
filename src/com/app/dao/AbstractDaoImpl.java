package com.app.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;

import com.app.util.Util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public abstract class AbstractDaoImpl {

	protected static JdbcTemplate jdbcTemplate;
	protected static MysqlDataSource ds = null;
	
	public AbstractDaoImpl() {
		ds = new MysqlDataSource();
		ds.setUrl(Util.getProperty("database.properties", "datasource.url"));
		ds.setUser(Util.getProperty("database.properties", "datasource.user"));
		ds.setPassword(Util.getProperty("database.properties", "datasource.password"));
		jdbcTemplate = new JdbcTemplate(ds);
	}
}
