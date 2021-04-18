package tiktzuki.selenium_grid.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public static WebElement manageUserNavItem(WebDriver driver) {
		WebElement el = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[1]/app-navbar/nav/ul/li[2]/a"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(el));
		wait.until(ExpectedConditions.elementToBeClickable(el));
		return el;
	}
	
	public static WebElement createUserNavItem(WebDriver driver) {
		WebElement el = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[1]/app-navbar/nav/ul/li[3]/a"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(el));
		return el;
	}
	
	public static WebElement profileNavItem(WebDriver driver) {
		WebElement el = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[1]/app-navbar/nav/ul/li[4]/a"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(el));
		return el;
	}
}
