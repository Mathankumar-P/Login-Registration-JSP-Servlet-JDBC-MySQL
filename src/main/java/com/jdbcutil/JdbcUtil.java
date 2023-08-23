package com.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.*;



public class JdbcUtil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getJdbcConnection() {
		Connection connection=null;
		try{
			String path = "E:\\Projects\\JspServletJdbc\\LoginRegister\\src\\main\\java\\com\\properties\\db.properties";
			FileInputStream fis = new FileInputStream(path);
			Properties properties = new Properties();
			properties.load(fis);
			String url =properties.getProperty("url");
			String user =properties.getProperty("user");
			String password =properties.getProperty("password");
			connection = DriverManager.getConnection(url,user,password);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
