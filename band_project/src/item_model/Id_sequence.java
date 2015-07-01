package item_model;

import java.io.Serializable;

public class Id_sequence implements Serializable {

	private String table_name;
	private int last_id;
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public int getLast_id() {
		return last_id;
	}
	public void setLast_id(int last_id) {
		this.last_id = last_id;
	}

}
