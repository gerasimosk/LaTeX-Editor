package strategies;

import java.util.ArrayList;
import model.Document;

public interface VersionsStrategy {
	
	public void putVersion(Document doc);
	public Document getVersion(Document document);
	public void setEntireHistory(ArrayList<Document> doc);
	public ArrayList<Document> getEntireHistory(Document document);
	public void removeVersion();
}
