package com.wwh.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteConn implements Serializable {
	private static final long serialVersionUID = 102400L;

	/**
	 * 与SQLite嵌入式数据库建立连接
	 * 
	 * @return Connection
	 * @throws Exception
	 */
	public Connection getConnection(String s) throws Exception {
		Connection connection = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// // 2.建立连接
			// connection = DriverManager.getConnection(
			// "jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=utf-8",
			// "root",
			// "123456");
			Class.forName("org.sqlite.JDBC");
			// 建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之
			connection = DriverManager.getConnection("jdbc:sqlite:market.db");
//			 Statement stat = connection.createStatement();
//	         stat.executeUpdate( "create table storehouse (p_barcode varchar(20), p_name varchar(20),p_producer varchar(20),sale_price float,p_number int,p_text text,vip_price float,in_price float);" );//创建一个表，两列

		} catch (Exception e) {
			throw new Exception("" + e.getLocalizedMessage(), new Throwable("可能由于数据库文件受到非法修改或删除。"));
		}
		return connection;
	}
}