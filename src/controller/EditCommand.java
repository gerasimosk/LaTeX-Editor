package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import strategies.VersionsStrategy;
import view.LatexEditorView;

public class EditCommand implements Command {

	@Override
	public Document execute(JTextArea text,String temp,String[] details,Document document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VersionsManager execute(VersionsManager version,LatexEditorView window) {
		if (!version.isEnabled()) {
			JOptionPane.showMessageDialog(window.getPane(),"Version tracking is disable!");
			return version;
		}
		Document document = version.getDocument().clone();
		document.setContents(window.gettext().getText());
		version.setDocument(document);		
		VersionsStrategy strategy = version.getStrategy();
		strategy.putVersion(version.getDocument());
		version.putStrategy(strategy);
		Document doc = version.getDocument().clone();
		doc.setVersionID(doc.getVersionID() + 1);
		version.setDocument(doc);
		return version;
	}
}
