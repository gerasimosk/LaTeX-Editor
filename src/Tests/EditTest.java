package Tests;

import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import controller.LatexEditorController;
import view.LatexEditorView;

class EditTest {
	@Test
	void test() {
		LatexEditorController controller=new LatexEditorController();
		JTextArea textArea = new JTextArea();
		String details[] = {"BillTitle","Bill","12/02/2019","Bill"};
		controller.enact("1",textArea,"5",details);
		LatexEditorView editor=new LatexEditorView();
		controller.enact("4",editor);
		
		if(!(controller.getDocument().getVersionID() == 1)) {
			System.out.println("Edit test failed!");
			return;
		}
		System.out.println("Edit test passed!");
	}
}
