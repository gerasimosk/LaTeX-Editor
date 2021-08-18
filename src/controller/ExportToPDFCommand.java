package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class ExportToPDFCommand implements Command {

	@Override
	public Document execute(JTextArea text, String path, String[] array, Document document) {
		Process p;
		try {
			document.save(System.getProperty("user.dir"));
			//String pathOfExe = "C:\\Users\\Gerasimos\\AppData\\Local\\Programs\\MiKTeX 2.9\\miktex\\bin\\x64\\pdflatex.exe";
			String temp = array[0] + " -output-directory " + path + " " + System.getProperty("user.dir") + "\\" + document.getTitle() + ".tex";
			p = Runtime.getRuntime().exec(temp);
		    p.waitFor();
		    if(p.exitValue() == 0) {
		    	JOptionPane.showMessageDialog(text,"Successful convertion to PDF!","Export",
				        JOptionPane.INFORMATION_MESSAGE);
		    }else {
		    	JOptionPane.showMessageDialog(text,"Problem converting to PDF","Export",
				        JOptionPane.INFORMATION_MESSAGE);
		    }
		    Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "\\" + document.getTitle() + ".tex"));
		    Files.deleteIfExists(Paths.get(path + "\\" + document.getTitle() + ".log"));
		    Files.deleteIfExists(Paths.get(path + "\\" + document.getTitle() + ".aux"));
		    Files.deleteIfExists(Paths.get(path + "\\" + document.getTitle() + ".out"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(text,"Problem converting to PDF","Export",
			        JOptionPane.INFORMATION_MESSAGE);
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(text,"Problem converting to PDF","Export",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		return document;
	}

	@Override
	public VersionsManager execute(VersionsManager version, LatexEditorView window) {
		// TODO Auto-generated method stub
		return null;
	}
}
