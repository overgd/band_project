package sch_model;

import java.io.Serializable;

public class Writing implements Serializable {
	private int writingid;
	private int groupid;
	private int orderno;
	private int parentid;
	private String writingdate;
	private String writerid;
	private String imagename;
	private String title;
	private String location;
	private String content;
	public int getWritingid() {
		return writingid;
	}
	public void setWritingid(int writingid) {
		this.writingid = writingid;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getWritingdate() {
		return writingdate;
	}
	public void setWritingdate(String writingdate) {
		this.writingdate = writingdate;
	}
	public String getWriterid() {
		return writerid;
	}
	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}