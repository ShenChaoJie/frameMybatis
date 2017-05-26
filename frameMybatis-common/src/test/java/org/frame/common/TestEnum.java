package org.frame.common;

public enum TestEnum {

	failed_noLog("105","失败|无日志"),
	failed_noReport("106","失败|无上报"),
	failed_noRegister("107","失败|无注册");
	
	TestEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}
	
	private String code;
	private String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
