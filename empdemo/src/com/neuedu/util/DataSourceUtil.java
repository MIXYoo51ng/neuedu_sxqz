package com.neuedu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class DataSourceUtil {
	
	private static DruidDataSource data;
	
	static{
		data = new DruidDataSource();
		Properties jdbcConfig = new Properties();
		try {
			jdbcConfig.load(DataSourceUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			data.setUrl(jdbcConfig.getProperty("url"));
			data.setUsername(jdbcConfig.getProperty("username"));
			data.setPassword(jdbcConfig.getProperty("password"));
//			data.setInitialSize(Integer.parseInt(jdbcConfig.getProperty("initsize")));
//			data.setMaxActive(Integer.parseInt(jdbcConfig.getProperty("maxactive")));
//			data.setMinIdle(Integer.parseInt(jdbcConfig.getProperty("minidle")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn =  data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
