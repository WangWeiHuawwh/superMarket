package com.wwh.bean;

public class CaculateBean {
	String barcode;
	String p_name;
	String p_producer;
	int sum_number;
	double all_in;
	double sum_money;
	double get_money;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
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

	public int getSum_number() {
		return sum_number;
	}

	public void setSum_number(int sum_number) {
		this.sum_number = sum_number;
	}

	public double getAll_in() {
		return all_in;
	}

	public void setAll_in(double all_in) {
		this.all_in = all_in;
	}

	public double getSum_money() {
		return sum_money;
	}

	public void setSum_money(double sum_money) {
		this.sum_money = sum_money;
	}

	public double getGet_money() {
		return get_money;
	}

	public void setGet_money(double get_money) {
		this.get_money = get_money;
	}

	@Override
	public String toString() {
		return "CaculateBean [barcode=" + barcode + ", p_name=" + p_name + ", p_producer=" + p_producer
				+ ", sum_number=" + sum_number + ", all_in=" + all_in + ", sum_money=" + sum_money + ", get_money="
				+ get_money + "]";
	}

}
