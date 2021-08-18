package controller;

import javax.swing.JTextArea;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class AddLatexCommand implements Command {
	
	@Override
	public Document execute(JTextArea text,String choice,String[] details,Document document) {
		String addChapter = "\\chapter{...}";
		String addSection = "\\section{}";
		String addSubsection = "\\subsection{}"; 
		String addSubsubsection = "\\subsubsection{}";
		String addItemizeList = "\\begin{itemize}\n\\item...\n\\item...\n\\end{itemize}";
		String addEnumerationList = "\\begin{enumerate}\n\\item...\n\\item...\n\\end{enumerate}";
		String addTable = "\\begin{table}\n\\caption{...}\\label{...}\n\\begin{tabular}{c|c|c|}\n \\hline\n"
				+ "...&...&...\\\\\n...&...&...\\\\\n...&...&...\\\\\n \\hline\n\\end{tabular}\n\\end{table}";
		String addFigure = "\\begin{figure}\n\\includegraphics[width=...,height=...] {...}\n\\caption{...}"
				+ "\\label{...}\n\\end{figure}";
		if(choice.equals("1")) {
			text.insert(addTable, text.getCaretPosition());
		}else if(choice.equals("2")) {
			text.insert(addFigure, text.getCaretPosition());
		}else if(choice.equals("3")) {
			text.insert(addSection, text.getCaretPosition());
		}else if(choice.equals("4")) {
			text.insert(addChapter, text.getCaretPosition());
		}else if(choice.equals("5")) {
			text.insert(addSubsection, text.getCaretPosition());
		}else if(choice.equals("6")) {
			text.insert(addItemizeList, text.getCaretPosition());
		}else if(choice.equals("7")) {
			text.insert(addSubsubsection, text.getCaretPosition());
		}else if(choice.equals("8")) {
			text.insert(addEnumerationList, text.getCaretPosition());
		}
		return document;
	}

	@Override
	public VersionsManager execute(VersionsManager version,LatexEditorView window) {
		// TODO Auto-generated method stub
		return null;
	}
}
