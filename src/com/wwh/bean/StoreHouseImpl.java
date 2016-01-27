package com.wwh.bean;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wwh.utils.DbManager;

public class StoreHouseImpl {
	Connection conn;

	public StoreHouseImpl() {
		conn = new DbManager().getConnect();
	}

	public void save(StoreHouseBean storehouseBean) {
		String ins_sql = "INSERT INTO storehouse (p_barcode, p_name, p_producer,sale_price,p_number,p_text,vip_price,in_price) VALUES (?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, storehouseBean.getP_barcode(), storehouseBean.getP_name(),
					storehouseBean.getP_producer(), storehouseBean.getSale_price(), storehouseBean.getP_number(),
					storehouseBean.getP_text(), storehouseBean.getVip_price(), storehouseBean.getIn_price());
			// ��ȡ������¼����������
			// id = (Long) qr.query(conn, "SELECT LAST_INSERT_ID()", new
			// ScalarHandler(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void savePurchase(PurchaseBean purchaseBean) {
		String ins_sql = "INSERT INTO purchase (barcode, in_price, buy_number,buy_date,produce_time,buy_user,save_day) VALUES (?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, purchaseBean.getBarcode(), purchaseBean.getIn_price(),
					purchaseBean.getBuy_number(), purchaseBean.getBuy_date(), purchaseBean.getProduce_time(),
					purchaseBean.getBuy_user(), purchaseBean.getSave_day());
			// ��ȡ������¼����������
			// id = (Long) qr.query(conn, "SELECT LAST_INSERT_ID()", new
			// ScalarHandler(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(StoreHouseBean storehouseBean) {
		String ins_sql = "UPDATE storehouse SET p_name = ?, p_producer = ? , sale_price = ? , p_number = ? , p_text = ? , p_producer = ? , vip_price = ? , in_price = ? WHERE p_barcode = ?";
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, ins_sql, storehouseBean.getP_name(), storehouseBean.getP_producer(),
					storehouseBean.getSale_price(), storehouseBean.getP_number(), storehouseBean.getP_text(),
					storehouseBean.getP_producer(), storehouseBean.getVip_price(), storehouseBean.getIn_price(),
					storehouseBean.getP_barcode());
			// ��ȡ������¼����������
			// id = (Long) qr.query(conn, "SELECT LAST_INSERT_ID()", new
			// ScalarHandler(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public StoreHouseBean findOne(String b_code) {
		QueryRunner qr = new QueryRunner();
		try {
			StoreHouseBean storeHouse = (StoreHouseBean) qr.query(conn, "SELECT * FROM storehouse where p_barcode = ?",
					new BeanHandler(StoreHouseBean.class), b_code);
			return storeHouse;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
