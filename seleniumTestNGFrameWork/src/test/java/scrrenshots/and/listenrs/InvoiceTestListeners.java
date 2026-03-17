package scrrenshots.and.listenrs;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;

//@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)  //if one class needs u can write like this else use this in xml
public class InvoiceTestListeners extends BaseClass {

	@Test
	public void createInvoiceTest() {
		System.out.println("execute createinvoicetest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login"); // asserterror exception
		System.out.println("s1");
		System.out.println("s2");
		System.out.println("s3");
		System.out.println("s4");
	}

	@Test
	public void createInvoiceContactTest() {
		System.out.println("execute createcontacttest");
	}
}
