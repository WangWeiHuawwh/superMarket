package com.wwh.bean;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.wwh.utils.DbManager;

public class VipImpl {
	Connection conn;

	public VipImpl() {
		conn = new DbManager().getConnect();
	}

	public VipBean findOne(String phone) {
		QueryRunner qr = new QueryRunner();
		try {
			VipBean vipBean = (VipBean) qr.query(conn, "SELECT * FROM vip where phone = ?",
					new BeanHandler(VipBean.class), phone);
			return vipBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
