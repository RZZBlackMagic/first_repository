package com.ideal.common;

import java.io.Serializable;

public class CommodityZtreeJsonResult implements Serializable {
   
	private Object obj;

	public CommodityZtreeJsonResult(Object obj) {
		super();
		this.obj = obj;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "CommodityZtreeJsonResult [obj=" + obj + "]";
	}
	
}
