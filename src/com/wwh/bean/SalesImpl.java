package com.wwh.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wwh.utils.DbManager;

public class SalesImpl {
	Connection conn;

	public SalesImpl() {
		conn = new DbManager().getConnect();
	}

	public void insert(SalesBean salesBean) {
		String ins_sql = "INSERT INTO sales (barcode, number, price,real_price,date,user,vip,summoney) VALUES (?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, salesBean.getBarcode(), salesBean.number, salesBean.price,
					salesBean.getReal_price(), salesBean.getDate(), salesBean.getUser(), salesBean.getVip(),
					salesBean.getSummoney());
			// 获取新增记录的自增主键
			// id = (Long) qr.query(conn, "SELECT LAST_INSERT_ID()", new
			// ScalarHandler(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<SalesBean> getSales() {
		QueryRunner qr = new QueryRunner();
		try {
			List<SalesBean> pset = (List) qr.query(conn, "SELECT * FROM sales", new BeanListHandler(SalesBean.class));
			return pset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
