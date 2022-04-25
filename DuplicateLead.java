package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//*Assignment 3:Duplicate Lead*
//1. Launch URL "http://leaftaps.com/opentaps/control/login"
//2. Enter UserName and Password Using Id Locator
//3. Click on Login Button using Class Locator
//4. Click on CRM/SFA Link
//5. Click on Leads Button
//6. Click on Create Lead 
//7. Enter CompanyName Field Using id Locator
//8. Enter FirstName Field Using id Locator
//9. Enter LastName Field Using id Locator
//10. Enter FirstName(Local) Field Using id Locator
//11. Enter Department Field Using any Locator of Your Choice
//12. Enter Description Field Using any Locator of your choice 
//13. Enter your email in the E-mail address Field using the locator of your choice
//14. Select State/Province as NewYork Using Visible Text
//15. Click on Create Button
//16. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
//17. Click on Duplicate button
//18. Clear the CompanyName Field using .clear() And Enter new CompanyName
//19.Clear the FirstName Field using .clear() And Enter new FirstName
//20.Click on Create Lead Button
//21. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
public class DuplicateLead extends AssignmentBaseClass {
	@Test
	public void duplicate() {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("SAI");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("RAm");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Hi Guys");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("saikumarram@tcs.com");
		WebElement selState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selSta = new Select(selState);
		selSta.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();

		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.linkText("Duplicate Lead")).click();
		WebElement comName = driver.findElement(By.id("createLeadForm_companyName"));
		comName.clear();
		comName.sendKeys("CTS");
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.clear();
		firstName.sendKeys("SaiRam");
		driver.findElement(By.className("smallSubmit")).click();

		String title2 = driver.getTitle();
		System.out.println(title2);
	}

}
