package com.wwh.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteConn implements Serializable {
	private static final long serialVersionUID = 102400L;

	/**
	 * ��SQLiteǶ��ʽ���ݿ⽨������
	 * 
	 * @return Connection
	 * @throws Exception
	 */
	public Connection getConnection(String s) throws Exception {
		Connection connection = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// // 2.��������
			// connection = DriverManager.getConnection(
			// "jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=utf-8",
			// "root",
			// "123456");
			Class.forName("org.sqlite.JDBC");
			// ����һ�����ݿ���zieckey.db�����ӣ���������ھ��ڵ�ǰĿ¼�´���֮
			connection = DriverManager.getConnection("jdbc:sqlite:market.db");
//			 Statement stat = connection.createStatement();
//	         stat.executeUpdate( "create table storehouse (p_barcode varchar(20), p_name varchar(20),p_producer varchar(20),sale_price float,p_number int,p_text text,vip_price float,in_price float);" );//����һ��������

		} catch (Exception e) {
			throw new Exception("" + e.getLocalizedMessage(), new Throwable("�����������ݿ��ļ��ܵ��Ƿ��޸Ļ�ɾ����"));
		}
		return connection;
	}
}