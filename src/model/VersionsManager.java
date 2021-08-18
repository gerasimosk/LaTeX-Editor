package model;

import java.util.ArrayList;
import strategies.VersionsStrategy;

public class VersionsManager {
	private Document document;
	private boolean enabled;
	private VersionsStrategy strategy;
	
	public VersionsManager(VersionsStrategy strategy) {
		this.strategy = strategy;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}
	
	public void disable() {
		enabled = false;
	}
	
	public void setCurrentVersion(Document document) {
		
	}
	
	public Document getPreviousVersion() {
		return null;
		// return
	}
	
	public Document rollbackToPreviousVersion() {
		Document doc = strategy.getVersion(document);
		if(doc!=null) {
			document = doc;
		}
		strategy.removeVersion();
		return doc;
	}
	
	public VersionsStrategy getStrategy() {
		return strategy;
	}
	
	public void setStrategy(VersionsStrategy new_strategy) {
		ArrayList<Document> history = new ArrayList<Document>();
		history = strategy.getEntireHistory(document);
		this.strategy = new_strategy;
		strategy.setEntireHistory(history);
	}
	
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Document getDocument() {
		return document;
	}
	
	public void putStrategy(VersionsStrategy strategy) {
		this.strategy = strategy;
	}
}
