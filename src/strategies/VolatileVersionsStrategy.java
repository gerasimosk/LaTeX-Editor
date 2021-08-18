package strategies;

import java.util.ArrayList;
import model.Document;

public class VolatileVersionsStrategy implements VersionsStrategy {
	private ArrayList<Document>RAM = new ArrayList<Document>();
	public VolatileVersionsStrategy() {}

	@Override
	public void putVersion(Document document) {
		RAM.add(document);
	}

	@Override
	public Document getVersion(Document document) {
		if (RAM.size() == 0) {
			return null;
		}else {
			document = RAM.remove(RAM.size() - 1);
			return document;
		}
	}

	@Override
	public void setEntireHistory(ArrayList<Document> documents) {
		for (int i=documents.size() -1; i>=0; i--) {
			RAM.add(documents.get(i).clone());
		}
	}

	@Override
	public ArrayList<Document> getEntireHistory(Document document) {
		return RAM;
	}

	@Override
	public void removeVersion() {
		// TODO Auto-generated method stub
	}
}
