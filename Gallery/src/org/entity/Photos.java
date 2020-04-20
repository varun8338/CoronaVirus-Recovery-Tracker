package org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;








@Entity(name = "photos")
@Table(name = "photos")
public class Photos {

	
	
	@Id
	@Column(name = "photo_id")
	private int photoId;
	
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "photo_name")
	private String photoName;
	
	@Column(name = "photo_label")
	private String photoLabel;
	
	@Column(name = "photo_caption")
	private String photoCaption;

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoLabel() {
		return photoLabel;
	}

	public void setPhotoLabel(String photoLabel) {
		this.photoLabel = photoLabel;
	}

	public String getPhotoCaption() {
		return photoCaption;
	}

	public void setPhotoCaption(String photoCaption) {
		this.photoCaption = photoCaption;
	}

	public Photos() {
		
	}
	
	

	public Photos(String userName, String photoName) {
		this.userName = userName;
		this.photoName = photoName;
	}

	@Override
	public String toString() {
		return "Photos [photoId=" + photoId + ", userName=" + userName + ", photoName=" + photoName + ", photoLabel="
				+ photoLabel + ", photoCaption=" + photoCaption + "]";
	}

    
	
}
