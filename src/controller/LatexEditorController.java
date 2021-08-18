package controller;

import java.util.HashMap;
import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import strategies.VersionsStrategyFactory;
import view.LatexEditorView;

public class LatexEditorController {
	private HashMap<String, String> map = new HashMap<String, String>();
	private Document document;
	private VersionsManager versions;
	private CommandsFactory factory = new CommandsFactory();
	public LatexEditorController() {
		map.put("1","create");
		map.put("2","add");
		map.put("3","rollback");
		map.put("4","edit");
		map.put("5","load");
		map.put("6","save");
		map.put("7","enable");
		map.put("8","disable");
		map.put("9","change");
		map.put("10","export");
		VersionsStrategyFactory strategy = new VersionsStrategyFactory();
		versions = new VersionsManager(strategy.createStrategy("VolatileVersionsStrategy"));
		versions.enable();
		
	}
	
	public void enact(String en,JTextArea text,String template,String[] details) {
		String temp = map.get(en);
		document = factory.createCommand(temp).execute(text,template,details,document);
		versions.setDocument(document);
	}
	
	public void enact(String en,LatexEditorView window) {
		String temp = map.get(en);
		versions = factory.createCommand(temp).execute(versions,window);
		document = versions.getDocument();
	}
	
	public Document getDocument() {
		return document;
	}
	
	public VersionsManager getVersionsManager() {
		return versions;
	}
}
