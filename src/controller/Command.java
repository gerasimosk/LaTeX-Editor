package controller;

import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public interface Command {
	public Document execute(JTextArea text,String temp,String[] details,Document document);
	public VersionsManager execute(VersionsManager version,LatexEditorView window);
}
