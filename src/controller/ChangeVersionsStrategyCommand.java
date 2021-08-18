package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import strategies.VersionsStrategyFactory;
import view.LatexEditorView;

public class ChangeVersionsStrategyCommand implements Command {

	@Override
	public Document execute(JTextArea text,String temp,String[] details,Document document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VersionsManager execute(VersionsManager version,LatexEditorView window) {
		if(!version.isEnabled()) {
			JOptionPane.showMessageDialog(window.getPane(),"Version tracking is disabled!");
			return version;
		}
		VersionsStrategyFactory strategy=new VersionsStrategyFactory();
		if (version.getStrategy().getClass().getName().equals("strategies.StableVersionsStrategy")) {
			version.setStrategy(strategy.createStrategy("VolatileVersionsStrategy"));
			JOptionPane.showMessageDialog(window.getPane(),"Strategy changed to Volatile");
		}else {
			version.setStrategy(strategy.createStrategy("StableVersionsStrategy"));
			JOptionPane.showMessageDialog(window.getPane(),"Strategy changed to Stable");
		}
		return version;
	}
}
