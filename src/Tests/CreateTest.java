package Tests;

import org.junit.jupiter.api.Test;
import model.Document;
import model.DocumentManager;

class CreateTest {
	@Test
	void test() {
		Document document;
		DocumentManager doc=new DocumentManager();
		String details[] = {"NewTitle","Bill","12/02/2019","Bill"};
		document = doc.createDocument("1",details);
		if(!document.getTitle().equals("NewTitle")) {
			System.out.println("Create test failed!");
			return;
		}
		if(!document.getAuthor().equals("Bill")) {
			System.out.println("Create test failed!");
			return;
		}
		if(!document.getDate().equals("12/02/2019")) {
			System.out.println("Create test failed!");
			return;
		}
		if(!document.getCopyright().equals("Bill")) {
			System.out.println("Create test failed!");
			return;
		}
		System.out.println("Create test passed!");
	}
}
