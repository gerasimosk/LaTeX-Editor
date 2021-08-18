package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class DocumentManager {
	private HashMap<String,Document>templates=new HashMap<String,Document>();
	private Document empty,report,book,article,letter;
	private Document temp;
	private String contents;
	public DocumentManager() {
	}
	
	public Document createDocument(String doc,String[] details) {
		String title = details[0];
		String author = details[1];
		String date = details[2];
		String copyright = details[3];
		String contentsArticle = fileContent(getClass().getResource("/article-template.tex").toString());
		String contentsBook = fileContent(getClass().getResource("/book-template.tex").toString());
		String contentsLetter = fileContent(getClass().getResource("/letter-template.tex").toString());
		String contentsReport = fileContent(getClass().getResource("/report-template.tex").toString());
		if (doc.equals("1")) {
			report = new Document(title,author,date,copyright,0,contentsReport);
		}else if(doc.equals("2")){
			book = new Document(title,author,date,copyright,0,contentsBook);
		}else if(doc.equals("3")){
			article = new Document(title,author,date,copyright,0,contentsArticle);
		}else if(doc.equals("4")) {
			letter = new Document(title,author,date,copyright,0,contentsLetter);
		}else {
			empty = new Document(title,author,date,copyright,0,"");
		}
		templates.put("5",empty);
		templates.put("1",report);
		templates.put("2",book);
		templates.put("3",article);
		templates.put("4",letter);
		temp = templates.get(doc).clone();
		return temp;
	}
	
	public String fileContent(String path) {
		try {
			String array[] = path.split(":");
			contents = new String(Files.readAllBytes(Paths.get(array[array.length - 1])));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;
	}
	
	public Document getDocument() {
		return temp;
	}
}
