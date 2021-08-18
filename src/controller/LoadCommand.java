package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class LoadCommand implements Command {
	@Override
	public Document execute(JTextArea text,String path,String[] details,Document document) {
		String name[] = path.split("\\.");
		if(name[name.length-1].equals("tex")) {
			StringBuilder contentBuilder = new StringBuilder();
			StringBuilder contentBuilder2 = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				int counter = 0;
				String sCurrentLine;
				String info;
				while ((sCurrentLine = br.readLine()) != null && counter<5)
		        {
		        	counter++;
		        	if(counter<6) {
		        		contentBuilder2.append(sCurrentLine).append("\n");
		        	}
		        }
				info = contentBuilder2.toString();
				while ((sCurrentLine = br.readLine()) != null)
		        {
		        	counter++;
		        	if(counter>=6) {
		        		contentBuilder.append(sCurrentLine).append("\n");
		        	}
		        }
		        String content = contentBuilder.toString();
		        String array[] = info.split("%|:|\\n|\\s+");
		        Document document2 = new Document(array[3],array[7],array[11],array[15],Integer.valueOf(array[19]),content);
		        text.setText(content);
		        return document2;
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
		}else {
			return null;
		}
		return null;
	}

	@Override
	public VersionsManager execute(VersionsManager version,LatexEditorView window) {
		// TODO Auto-generated method stub
		return null;
	}
}
