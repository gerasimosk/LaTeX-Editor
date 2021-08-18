package Tests;

import org.junit.jupiter.api.Test;
import controller.LatexEditorController;
import view.LatexEditorView;

class EnableTest {
	@Test
	void test() {
		LatexEditorController controller = new LatexEditorController();
		LatexEditorView editor = new LatexEditorView();
		controller.enact("7",editor);
		if(!controller.getVersionsManager().isEnabled()) {
			System.out.println("Enable test failed!");
			return;
		}
		System.out.println("Enable test passed!");
	}
}