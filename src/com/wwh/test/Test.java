package com.wwh.test;

import java.util.List;

import com.wwh.bean.SalesBean;
import com.wwh.bean.SalesImpl;
import com.wwh.bean.StoreHouseBean;
import com.wwh.bean.StoreHouseImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// StoreHouseImpl storeHouseimpl = new StoreHouseImpl();
		// StoreHouseBean storeHousebean = new StoreHouseBean();
		// storeHousebean.setP_barcode("10010");
		// storeHousebean.setP_name("不知道什么");
		// storeHousebean.setIn_price(10d);
		// storeHousebean.setP_number(100);
		// storeHousebean.setP_producer("尝试");
		// storeHousebean.setSale_price(20d);
		// storeHousebean.setP_text(".");
		// storeHousebean.setVip_price(18d);
		// storeHouseimpl.save(storeHousebean);
		// StoreHouseBean storeHousebean2 = storeHouseimpl.findOne("10010");
		SalesImpl salesImpl = new SalesImpl();
		List<SalesBean> sales = salesImpl.getSales();
		for (SalesBean s : sales) {
			System.out.println(s.toString());
		}
	}

}
