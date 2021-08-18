package Tests;

import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import controller.LatexEditorController;
import view.LatexEditorView;

class ChangeStrategyTest {

	@Test
	void test() {
		LatexEditorController controller=new LatexEditorController();
		JTextArea textArea = new JTextArea();
		String details[] = {"BillTitle","Bill","12/02/2019","Bill"};
		controller.enact("1",textArea,"5",details);
		LatexEditorView editor = new LatexEditorView();
		System.out.println("default is volatile the next change is stable");
		controller.enact("9",editor);
		System.out.println("now the strategy is going to change to volatile");
		controller.enact("9",editor);
	}
}
