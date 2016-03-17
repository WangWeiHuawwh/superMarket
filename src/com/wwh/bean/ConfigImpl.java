package com.wwh.bean;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.wwh.utils.DbManager;

public class ConfigImpl {
	Connection conn;

	public ConfigImpl() {
		conn = new DbManager().getConnect();
	}
	public ConfigBean get() {
		QueryRunner qr = new QueryRunner();
		try {
			ConfigBean vipBean = (ConfigBean) qr.query(conn, "SELECT * FROM config",
					new BeanHandler(ConfigBean.class));
			return vipBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void update(ConfigBean configbean) {
		String ins_sql = "UPDATE config SET baoint = ?, uproduce = ? , bili = ? WHERE id = ?";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, configbean.getBaoint(),configbean.getUproduce(),configbean.getBili(),configbean.getId());
			// 获取新增记录的自增主键
			// id = (Long) qr.query(conn, "SELECT LAST_INSERT_ID()", new
			// ScalarHandler(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
