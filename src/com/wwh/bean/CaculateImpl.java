package com.wwh.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wwh.utils.DbManager;

public class CaculateImpl {
	Connection conn;

	public CaculateImpl() {
		conn = new DbManager().getConnect();
	}

	public List<CaculateBean> getyear(String year) {
		QueryRunner qr = new QueryRunner();
		try {
			List<CaculateBean> pset = (List) qr.query(conn,
					"select a.barcode,b.p_name,p_producer,sum(number) as sum_number,in_price*sum(number) as all_in,sum(summoney) as sum_money,sum(summoney)-in_price*sum(number) as get_money from sales as a,storehouse as b where a.barcode=b.p_barcode and substr(a.date,1,4)='"
							+ year + "' group by a.barcode",
					new BeanListHandler(CaculateBean.class));
			return pset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<CaculateBean> getday(String year, String moth, String day) {
		QueryRunner qr = new QueryRunner();
		try {
			List<CaculateBean> pset = (List) qr.query(conn,
					"select a.barcode,b.p_name,p_producer,sum(number) as sum_number,in_price*sum(number) as all_in,sum(summoney) as sum_money,sum(summoney)-in_price*sum(number) as get_money from sales as a,storehouse as b where a.barcode=b.p_barcode and substr(a.date,1,4)='"
							+ year + "' and substr(a.date,6,2)='" + moth + "' and substr(a.date,9,2)='" + day
							+ "' group by a.barcode",
					new BeanListHandler(CaculateBean.class));
			return pset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<CaculateBean> getmoth(String year, String moth) {
		QueryRunner qr = new QueryRunner();
		try {
			List<CaculateBean> pset = (List) qr.query(conn,
					"select a.barcode,b.p_name,p_producer,sum(number) as sum_number,in_price*sum(number) as all_in,sum(summoney) as sum_money,sum(summoney)-in_price*sum(number) as get_money from sales as a,storehouse as b where a.barcode=b.p_barcode and substr(a.date,1,4)='"
							+ year + "' and substr(a.date,6,2)='" + moth + "' group by a.barcode",
					new BeanListHandler(CaculateBean.class));
			return pset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Vector<Vector<Object>> getYear(String year) {
		// QueryRunner qr = new QueryRunner();
		// try {
		// List<CaculateBean> pset = (List) qr.query(conn,
		// "select a.barcode,b.p_name,p_producer,sum(number) as
		// sum_number,in_price*sum(number) as all_in,sum(summoney) as
		// sum_money,sum(summoney)-in_price*sum(number) as get_money from sales
		// as a,storehouse as b where a.barcode=b.p_barcode and
		// substr(a.date,0,4)='2016' group by a.barcode",
		// new BeanListHandler(CaculateBean.class));
		// return pset;
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// return null;
		Statement stmt = null;
		ResultSet rs = null;

		Vector<Vector<Object>> value = new Vector<Vector<Object>>();

		String sql = "select a.barcode,b.p_name,p_producer,sum(number) as sum_number,in_price*sum(number) as all_in,sum(summoney) as sum_money,sum(summoney)-in_price*sum(number) as get_money from sales as a,storehouse as b where a.barcode=b.p_barcode and substr(a.date,1,4)='"
				+ year + "' group by a.barcode;";
		try {
			stmt = this.conn.createStatement();
			rs = stmt.executeQuery(sql);
			int columnCounts = getFieldsCounts(rs);
			System.out.println("boolean" + rs.next());
			while (true) {
				Vector<Object> valueVector = new Vector<Object>();
				for (int i = 1; i <= columnCounts; i++) {
					valueVector.addElement(rs.getObject(i));
				}
				value.addElement(valueVector);
				if (!rs.next()) {
					break;
				}
			}
			return value;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;

	}

	public int getFieldsCounts(ResultSet resultSet) {
		try {
			return resultSet.getMetaData().getColumnCount();
		} catch (SQLException e) {
			System.out.println("加载表中字段异常 ：" + e.getLocalizedMessage());
			return 0;
		}
	}

	public List<String> getFields(ResultSet resultSet) {
		List<String> fieldsList = new ArrayList<String>();
		try {
			int columnCounts = resultSet.getMetaData().getColumnCount();
			for (int i = 1; i <= columnCounts; i++) {
				fieldsList.add(resultSet.getMetaData().getColumnName(i));
			}
		} catch (SQLException e) {
			System.out.println("加载表中字段异常 ：" + e.getLocalizedMessage());
			return null;
		}
		return fieldsList;
	}
}
