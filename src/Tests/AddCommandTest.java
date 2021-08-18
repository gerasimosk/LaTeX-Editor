package Tests;

import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import controller.LatexEditorController;

class AddCommandTest {

	@Test
	void test() {
		JTextArea text = new JTextArea();
		LatexEditorController con=new LatexEditorController();
		con.enact("2",text,"4",null);
		if (text.getText().equals("\n\\chapter{...}\n")) {
			System.out.println("Add test passed the test!");
		}else {
			System.out.println("Add test did not pass the test!");
		}
	}
}
