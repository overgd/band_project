package qna_model;

import java.io.Serializable;

public class Qna_info implements Serializable {

	private int parent_id;
	private int writing_id;
	private int order_no;
	private String writer_id;
	private String writing_date;
	private String title;
	private String band_id;
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getWriting_id() {
		return writing_id;
	}
	public void setWriting_id(int writing_id) {
		this.writing_id = writing_id;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getWriting_date() {
		return writing_date;
	}
	public void setWriting_date(String writing_date) {
		this.writing_date = writing_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBand_id() {
		return band_id;
	}
	public void setBand_id(String band_id) {
		this.band_id = band_id;
	}
	
	
	
}
