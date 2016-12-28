package com.dou.common.datasource;


/**
 * @date 2016/5/30 14:36
 */
public enum DataSourceType {
	read("read", "从库"), write("write", "主库");
	private String type;
	private String name;
	
	DataSourceType(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
