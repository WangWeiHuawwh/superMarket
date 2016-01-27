package com.wwh.utils;

public class Application {
	public static String eid;

	public static String getEid() {
		if(eid==null)
		{
			eid="unkown";
		}
		return eid;
	}

	public static void setEid(String eid) {
		Application.eid = eid;
	}

}
