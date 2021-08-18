package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Document implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String date;
	private String copyright;
	private int versionID;
	private String contents;
	
	
	public Document(String title,String author,String date,String copyright,int versionID,String contents) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
	}
	
	public String getAuthor() {
		return author;
	}
	public String getDate() {
		return date;
	}
	public String getCopyright() {
		return copyright;
	}
	public int getVersionID() {
		return versionID;
	}
	public void setContents(String cont) {
		contents=cont;
	}
	public String getContents() {
		return contents;
	}
	public void save(String path) {
			try {
				
				File latex = new File(path+File.separator+this.title+".tex");
				latex.createNewFile();
				FileWriter writer = new FileWriter(latex);
				BufferedWriter buf = new BufferedWriter (writer);
				buf.write(this.contents);
				buf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public Document clone() {
		Document document = new Document(this.title,this.author,this.date,this.copyright,this.versionID,this.contents);
		return document;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setVersionID(int versionID) {
		this.versionID = versionID;
	}
}
