package guest_model;

import java.io.Serializable;

public class Writing implements Serializable {
	private int writingid;
	private int groupid;
	private int parentid;
	private int orderno;
	private String writerid;
	private String bandid;
	private String writingdate;
	private String title;
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
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getBandid() {
		return bandid;
	}
	public void setBandid(String bandid) {
		this.bandid = bandid;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getWriterid() {
		return writerid;
	}
	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}
	public String getWritingdate() {
		return writingdate;
	}
	public void setWritingdate(String writingdate) {
		this.writingdate = writingdate;
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
	
}
