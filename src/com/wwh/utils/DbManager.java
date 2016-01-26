package com.wwh.utils;

import java.sql.Connection;

public class DbManager {
	public Connection connection;

	public Connection getConnect() {
		if (connection == null) {
			try {
				connection = (new SQLiteConn()).getConnection("supermarket.db");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}

}
