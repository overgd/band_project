package user_model;

import item_model.Album;

import java.io.Serializable;

public class Cart implements Serializable {

	private Album album;
	private int number;
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
