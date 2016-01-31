package com.wwh.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wwh.utils.DbManager;

public class UserImpl {
	Connection conn;

	public UserImpl() {
		conn = new DbManager().getConnect();
	}

	public void save(UserBean userBean) {
		String ins_sql = "INSERT INTO user (eid, ename, job,pwd,phone) VALUES (?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, userBean.getEid(), userBean.getEname(), userBean.getJob(), userBean.getPwd(),
					userBean.getPhone());
			// 获取新增记录的自增主键
			// id = (Long) qr.query(conn, "SELECT LAST_INSERT_ID()", new
			// ScalarHandler(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<UserBean> getAll() {
		QueryRunner qr = new QueryRunner();
		try {
			List<UserBean> pset = (List) qr.query(conn, "SELECT * FROM user",
					new BeanListHandler(UserBean.class));
			return pset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
