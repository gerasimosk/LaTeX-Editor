package controller;

import javax.swing.JTextArea;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CreateCommand implements Command {
	private Document document;
	private String string;
	public CreateCommand() {}
	
	public Document execute(JTextArea text,String template,String[] details,Document doca) {
		DocumentManager doc=new DocumentManager();
		document = doc.createDocument(template,details);
		string =  document.getContents();
		text.setText(string);
		return document;
	}

	public Document getDocument() {
		return document;
	}

	public VersionsManager execute(VersionsManager version,LatexEditorView window) {
		// TODO Auto-generated method stub
		return null;
	}
}
