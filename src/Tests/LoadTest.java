package Tests;

import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import controller.LatexEditorController;

class LoadTest {
	String contents;
	JTextArea text = new JTextArea();
	@Test
	void test() {
		String path = getClass().getResource("/").toString() + "BillTitle.tex";
		String array[] = path.split(":");
		LatexEditorController controller = new LatexEditorController();
		System.out.println(array[2]);
		controller.enact("5",text,array[2],null);
		if(!controller.getDocument().getTitle().equals("New Title")) {
			System.out.println("Load test failed!");
			return;
		}
		if(!controller.getDocument().getAuthor().equals("Bill")) {
			System.out.println("Load test failed!");
			return;
		}
		if(!controller.getDocument().getDate().equals("12/02/2019")) {
			System.out.println("Load test failed!");
			return;
		}
		if(!controller.getDocument().getCopyright().equals("Bill")) {
			System.out.println("Load test failed!");
			return;
		}
		System.out.println("Load test passed!");
	}
}
