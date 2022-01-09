package com.example.demo.Entity;

import java.util.Date;

/* ENTITY FOR DATABASE */
public class Record {
	int Id;
	String ImgUrl;
	Date SbmDate;
	Date JdgDate;
	String JdgRes;

	public Record() {
		super();
	}

	public Record(String url, Date date) {
		super();
		this.ImgUrl = url;
		this.SbmDate = date;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public void setImgUrl(String url) {
		this.ImgUrl = url;
	}

	public void setSbmDate(Date date) {
		this.SbmDate = date;
	}

	public void setJdgDate(Date date) {
		this.JdgDate = date;
	}

	public void setJdgRes(String levl) {
		this.JdgRes = levl;
	}

	public int getId() {
		return Id;
	}

	public String getImgUrl() {
		return ImgUrl;
	}

	public Date getSbmDate() {
		return SbmDate;
	}

	public Date getJdgDate() {
		return JdgDate;
	}

	public String getJdgRes() {
		return JdgRes;
	}

}
