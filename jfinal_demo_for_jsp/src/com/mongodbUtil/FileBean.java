package com.mongodbUtil;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

public class FileBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1643355282466382972L;
	private InputStream inputStream;
	private String fileName;
	private String fileType;

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream
	 *            the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		if (this.fileName == null)
			this.fileName = Long.toString(new Date().getTime());
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
