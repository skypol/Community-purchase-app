package com.example.util;
//从服务器获取商品信息
import java.io.Serializable;//序列化传输存储

public class news implements Serializable {
	private String title;
	private String name;
	private String ps;
	private String tel;
	private String price;
	private String type;
	private String id;
	private String msg;
	private String img;
	private String time;
	int shuliang,shuliang1;
	public int getShuliang() {
		return shuliang;
	}
	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}
	public int getShuliang1() {
		return shuliang1;
	}
	public void setShuliang1(int shuliang1) {
		this.shuliang1 = shuliang1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public news() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


}
