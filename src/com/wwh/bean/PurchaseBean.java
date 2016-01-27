package com.wwh.bean;

import java.sql.Date;

public class PurchaseBean {
	public Integer id;
	public String barcode;
	public Double in_price;
	public Integer buy_number;
	public String buy_date;
	public String produce_time;
	public String buy_user;
	public Integer save_day;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Double getIn_price() {
		return in_price;
	}

	public void setIn_price(Double in_price) {
		this.in_price = in_price;
	}

	public Integer getBuy_number() {
		return buy_number;
	}

	public void setBuy_number(Integer buy_number) {
		this.buy_number = buy_number;
	}

	public String getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}

	public String getProduce_time() {
		return produce_time;
	}

	public void setProduce_time(String produce_time) {
		this.produce_time = produce_time;
	}

	public String getBuy_user() {
		return buy_user;
	}

	public void setBuy_user(String buy_user) {
		this.buy_user = buy_user;
	}

	public Integer getSave_day() {
		return save_day;
	}

	public void setSave_day(Integer save_day) {
		this.save_day = save_day;
	}

	@Override
	public String toString() {
		return "PurchaseBean [id=" + id + ", barcode=" + barcode + ", in_price=" + in_price + ", buy_number="
				+ buy_number + ", buy_date=" + buy_date + ", produce_time=" + produce_time + ", buy_user=" + buy_user
				+ ", save_day=" + save_day + "]";
	}

}
