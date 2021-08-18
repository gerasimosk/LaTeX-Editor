package strategies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import model.Document;

public class StableVersionsStrategy implements VersionsStrategy {
	private String path;
	public StableVersionsStrategy() {}

	@Override
	public void putVersion(Document document) {
		String pathOpen = System.getProperty("user.dir");
		pathOpen = pathOpen +"\\Versions" + "\\" + document.getVersionID() + "_" + document.getTitle();
		try {
			FileOutputStream outfile=new FileOutputStream(pathOpen);
			ObjectOutputStream object=new ObjectOutputStream(outfile);
			object.writeObject(document);
			object.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Document getVersion(Document document) {
		path = System.getProperty("user.dir");
		path = path +"\\Versions" + "\\" + (document.getVersionID() - 1) + "_" + document.getTitle();
		FileInputStream outfile;
		Object temp = null;
		try {
			outfile = new FileInputStream(path);
			ObjectInputStream object = new ObjectInputStream(outfile);
			temp = object.readObject();
			object.close();
			removeVersion();
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
		return (Document) temp;
	}

	@Override
	public void setEntireHistory(ArrayList<Document> documents) {
		for(int i = 0; i<documents.size(); i++) {
			Document document = documents.get(i);
			putVersion(document.clone());
		}
	}

	@Override
	public ArrayList<Document> getEntireHistory(Document document) {
		ArrayList<Document> history = new ArrayList<Document>();
		Document temp = getVersion(document);
		while(temp!=null) {
			history.add(temp.clone());
			temp = getVersion(temp);
		}
		return history;
	}

	@Override
	public void removeVersion() {
		try {
			Files.deleteIfExists(Paths.get(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
