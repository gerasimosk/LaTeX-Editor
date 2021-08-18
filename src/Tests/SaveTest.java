package Tests;

import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import controller.LatexEditorController;

class SaveTest {
	@Test
	void test() {
		LatexEditorController controller = new LatexEditorController();
		JTextArea textArea = new JTextArea();
		String details[] = {"BillTitle","Bill","12/02/2019","Bill"};
		controller.enact("1",textArea,"5",details);

		String pathSave = System.getProperty("user.dir");
		pathSave = pathSave+"\\bin";
		controller.enact("6",textArea,pathSave,null);
		String pathOpen = System.getProperty("user.dir");
		pathOpen = pathOpen +"\\bin" + "\\BillTitle.tex";
		controller.enact("5",textArea,pathOpen,null);
		if(!controller.getDocument().getTitle().equals("BillTitle")) {
			System.out.println("Save test failed!");
			return;
		}
		if(!controller.getDocument().getAuthor().equals("Bill")) {
			System.out.println("Save test failed!");
			return;
		}
		if(!controller.getDocument().getDate().equals("12/02/2019")) {
			System.out.println("Save test failed!");
			return;
		}
		if(!controller.getDocument().getCopyright().equals("Bill")) {
			System.out.println("Save test failed!");
			return;
		}
		System.out.println("Save test passed!");
	}
}
