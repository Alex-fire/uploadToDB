package net.codejava.fileupload.model;

import javax.persistence.*;

@Entity
@Table(name = "files_upload")
public class UploadFile {
	private long id;
	private String fileName;
	private byte[] data;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "FILE_DATA")
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
