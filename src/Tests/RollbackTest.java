package Tests;

import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import controller.LatexEditorController;
import view.LatexEditorView;

class RollbackTest {
	@Test
	void test() {
		LatexEditorController controller = new LatexEditorController();
		JTextArea textArea = new JTextArea();
		String details[] = {"BillTitle","Bill","12/02/2019","Bill"};
		controller.enact("1",textArea,"5",details);
		LatexEditorView editor = new LatexEditorView();
		controller.enact("4",editor);
		System.out.println("Edit ID 1: "+ (controller.getDocument().getVersionID() -1));
		controller.enact("4",editor);
		System.out.println("Edit ID 2: "+ (controller.getDocument().getVersionID()-1));
		controller.enact("3",editor);
		System.out.println("Rollback ID : "+controller.getDocument().getVersionID());
		if(!(controller.getDocument().getVersionID() == 1)) {
			System.out.println("Rollback test failed!");
			return;
		}
		System.out.println("Rollback test passed!");
	}
}
