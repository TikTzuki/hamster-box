package tiktzuki.selenium_grid.testcases.delete_user;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tiktzuki.selenium_grid.actions.Login;
import tiktzuki.selenium_grid.pages.HomePage;
import tiktzuki.selenium_grid.pages.ManagerUserPage;
import tiktzuki.selenium_grid.utils.SetupDriver;

public class TestDeleteUser {
	public WebDriver driver;
	
	@BeforeClass
	@Parameters({"os", "browser", "url", "node"})
	public void setup(String os, String browser, String url, String node) throws MalformedURLException {
		SetupDriver setupTestDriver = new SetupDriver(os, browser, url, node);
		driver = setupTestDriver.getDriver();
	}
	
	public TestDeleteUser() {
		
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		Login.Execute(driver);
	}
	
	@Test(priority = 2)
	public void gotoManageUser() throws InterruptedException {
		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		builder.moveToElement(HomePage.manageUserNavItem(driver)).perform();
		Thread.sleep(2000);
		HomePage.manageUserNavItem(driver).click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 3)
	public void deleteUser() throws InterruptedException {
		ManagerUserPage.btnDeleteByUsername(driver, "tiktzuki").click();
//		if(btnDelete!=null) {
//			System.out.println(btnDelete.getText());
//		}
//		btnDelete.click();
		Thread.sleep(2000);
		List<WebElement> cells = ManagerUserPage.colAt(driver, 1);
		for(WebElement cell: cells) {
			System.out.println(cell.getText());
		}
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
