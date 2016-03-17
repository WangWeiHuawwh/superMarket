package com.wwh.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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

	public void save(VipBean vipBean) {
		String ins_sql = "INSERT INTO vip (name, score, phone,address) VALUES (?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, vipBean.getName(), vipBean.getScore(), vipBean.getPhone(), vipBean.getAddress());
			// 获取新增记录的自增主键
			// id = (Long) qr.query(conn, "SELECT LAST_INSERT_ID()", new
			// ScalarHandler(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(VipBean vipBean) {
		String ins_sql = "UPDATE vip SET score = ? WHERE phone = ?";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, vipBean.getScore(), vipBean.getPhone());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<VipBean> getAll() {
		QueryRunner qr = new QueryRunner();
		try {
			List<VipBean> pset = (List) qr.query(conn, "SELECT * FROM vip", new BeanListHandler(VipBean.class));
			return pset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
