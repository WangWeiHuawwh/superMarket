package com.wwh.bean;

public class StoreHouseBean {
	public String p_barcode;
	public String p_name;
	public String p_producer;
	public Double sale_price;
	public Integer p_number;
	public String p_text;
	public Double vip_price;
	public Double in_price;
	public String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setP_number(Integer p_number) {
		this.p_number = p_number;
	}

	public String getP_barcode() {
		return p_barcode;
	}

	public void setP_barcode(String p_barcode) {
		this.p_barcode = p_barcode;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_producer() {
		return p_producer;
	}

	public void setP_producer(String p_producer) {
		this.p_producer = p_producer;
	}

	public Double getSale_price() {
		return sale_price;
	}

	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}

	public int getP_number() {
		return p_number;
	}

	public void setP_number(int p_number) {
		this.p_number = p_number;
	}

	public String getP_text() {
		return p_text;
	}

	public void setP_text(String p_text) {
		this.p_text = p_text;
	}

	public Double getVip_price() {
		return vip_price;
	}

	public void setVip_price(Double vip_price) {
		this.vip_price = vip_price;
	}

	public Double getIn_price() {
		return in_price;
	}

	public void setIn_price(Double in_price) {
		this.in_price = in_price;
	}

	@Override
	public String toString() {
		return "StoreHouseBean [p_barcode=" + p_barcode + ", p_name=" + p_name + ", p_producer=" + p_producer
				+ ", sale_price=" + sale_price + ", p_number=" + p_number + ", p_text=" + p_text + ", vip_price="
				+ vip_price + ", in_price=" + in_price + "]";
	}

}
