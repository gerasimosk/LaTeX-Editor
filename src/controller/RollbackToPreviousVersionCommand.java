package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class RollbackToPreviousVersionCommand implements Command {

	@Override
	public Document execute(JTextArea text,String temp,String[] details,Document document) {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public VersionsManager execute(VersionsManager version,LatexEditorView window) {
		if(version.isEnabled()) {
			Document document = version.rollbackToPreviousVersion();
			if(document == null) {
				JOptionPane.showMessageDialog(window.getPane(),"There is not previous version!");
			}else {
				version.setDocument(document);
				window.gettext().setText(version.getDocument().getContents());
			}
		}else {
			JOptionPane.showMessageDialog(window.getPane(),"Warning: Version tracking is disabled!");
		}
		return version;
	}
}
