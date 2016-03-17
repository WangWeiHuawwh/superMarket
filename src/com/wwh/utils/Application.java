package com.wwh.utils;

public class Application {
	public static String eid;
	public static double bili = 2;

	public static String getEid() {
		if (eid == null) {
			eid = "unkown";
		}
		return eid;
	}

	public static void setEid(String eid) {
		Application.eid = eid;
	}
	public static double getbili(){
		return bili;
	}

}
