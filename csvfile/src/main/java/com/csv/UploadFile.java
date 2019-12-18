package com.csv;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILES_UPLOAD")
public class UploadFile {
private long id;
private String fileName;
private byte[] data;
private Date date;
@Column(name ="date")
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Id
@GeneratedValue
@Column(name = "FILE_ID")
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
@Column(name = "FILE_NAME", length = 500)
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
@Column(name = "FILE_DATA", length = 2024)
public byte[] getData() {
	return data;
}
public void setData(byte[] data) {
	this.data = data;
}


}