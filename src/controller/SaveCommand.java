package controller;

import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class SaveCommand implements Command {
	@Override
	public Document execute(JTextArea text,String path,String[] details,Document document) {
		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append("%Title: " + document.getTitle()).append("\n");
		contentBuilder.append("%Author: " + document.getAuthor()).append("\n");
		contentBuilder.append("%Date: " + document.getDate()).append("\n");
		contentBuilder.append("%Copyright: " + document.getCopyright()).append("\n");
		contentBuilder.append("%VersionID: " + document.getVersionID()).append("\n");
		contentBuilder.append("").append("\n");
		contentBuilder.append(text.getText()).append("\n");
		document.setContents(contentBuilder.toString());
		document.save(path);
		return document;
	}

	@Override
	public VersionsManager execute(VersionsManager version,LatexEditorView window) {
		// TODO Auto-generated method stub
		return null;
	}	
}
