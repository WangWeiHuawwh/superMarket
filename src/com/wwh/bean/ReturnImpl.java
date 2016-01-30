package com.wwh.bean;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.wwh.utils.DbManager;

public class ReturnImpl {
	Connection conn;

	public ReturnImpl() {
		conn = new DbManager().getConnect();
	}

	public void insert(ReturnBean returnBean) {
		String ins_sql = "INSERT INTO return (barcode,name, number, price,eid,return_date) VALUES (?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, returnBean.getBarcode(), returnBean.getName(), returnBean.getNumber(),
					returnBean.getPrice(), returnBean.getEid(), returnBean.getReturn_date());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
