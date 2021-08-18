package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class DisableVersionsManagementCommand implements Command {

	@Override
	public Document execute(JTextArea text,String temp,String[] details,Document document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VersionsManager execute(VersionsManager version,LatexEditorView window) {
		if (!version.isEnabled()) {
			JOptionPane.showMessageDialog(window.getPane(),"Version tracking is already disable!");
		}else {
			version.disable();
			JOptionPane.showMessageDialog(window.getPane(),"Version tracking is changed to disable!");
		}
		return version;
	}
}
