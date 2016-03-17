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
			 Statement stat = connection.createStatement();
			 //stat.executeUpdate("create table storehouse (p_barcode varchar(20) primary key,p_name varchar(20) not null,p_producer varchar(20) not null,sale_price float,p_number int,p_text text,vip_price float,in_price float,image varchar(50));");// 创建一个表，两列
			 //stat.executeUpdate("create table purchase (id INTEGER PRIMARY KEY AUTOINCREMENT,barcode varchar(20) not null,in_price float,buy_number int,buy_date varchar(20),produce_time varchar(20),buy_user varchar(20) not null,save_day int);");
			 //stat.executeUpdate("create table user (eid varchar(20) primary key,ename varchar(20) not null,job varchar(20) not null,pwd varchar(20) not null,phone varchar(20) not null);");
			 //stat.executeUpdate("create table sales (id INTEGER PRIMARY KEY AUTOINCREMENT,barcode varchar(20) not null,number int,price float,real_price float,date varchar(20),user varchar(20),vip varchar(20),summoney float);");
			 //stat.executeUpdate("create table vip (id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20),score int,phone varchar(20),address varchar(50));");
			 //stat.executeUpdate("create table return (id INTEGER PRIMARY KEY AUTOINCREMENT,barcode varchar(20) not null,name varchar(20) not null,number int,price float not null,eid varchar(20),return_date varchar(20));");
			 //stat.executeUpdate("create table config (id int default 1,baoint int default 200,uproduce text default '',bili float default 1.0);");
		} catch (Exception e) {
			throw new Exception("" + e.getLocalizedMessage(), new Throwable("可能由于数据库文件受到非法修改或删除。"));
		}
		return connection;
	}
}