package acme1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Invoices {
	@Test

	public void findInv() throws Exception {
		// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "./Folders/chromedriver.exe");
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://acme-test.uipath.com/account/login");
			driver.manage().window().maximize();
			driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
			driver.findElementById("password").sendKeys("leaf@12");
			driver.findElementById("buttonLogin").click();
			Thread.sleep(5000);
			WebElement Invoice = driver.findElementByXPath("//button[text()[normalize-space()='Invoices']]");
			Thread.sleep(2000);
			Actions builder =new Actions(driver);
			Thread.sleep(5000);
			builder.moveToElement(Invoice).perform();
			driver.findElementByLinkText("Search for Invoice").click();
			driver.findElementById("vendorTaxID").sendKeys("DE763212");
			driver.findElementById("buttonSearch").click();
			
			Thread.sleep(1000);
			List<WebElement> tableRows = driver.findElementsByXPath("//table[@class='table']//tr");
			int rowSize = tableRows.size();
			
			for (int i = 2; i < rowSize; i++) {
				WebElement Inv = driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[3]");
				String text = Inv.getText();
			
			//System.out.println(text);
			if(text.equals("IT Support")) {
				System.out.println(driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[1]").getText());
				
			}
			}
			driver.findElementByLinkText("Log Out").click();
			driver.close();
				
			
			
			 
			
			
			


	}

}
