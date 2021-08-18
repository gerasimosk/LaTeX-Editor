package Tests;

import org.junit.jupiter.api.Test;
import controller.LatexEditorController;
import view.LatexEditorView;

class DisableTest {
	@Test
	void test() {
		LatexEditorController controller=new LatexEditorController();
		LatexEditorView editor = new LatexEditorView();
		controller.enact("8",editor);
		if(!controller.getVersionsManager().isEnabled()) {
			System.out.println("Disable test failed!");
			return;
		}
		System.out.println("Disable test passed!");
	}
}
