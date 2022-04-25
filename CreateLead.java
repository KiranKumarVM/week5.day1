package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//*Assignment 1:Create Lead*
//	  1. Launch URL "http://leaftaps.com/opentaps/control/login"
//	  2. Enter UserName and Password Using Id Locator
//	  3. Click on Login Button using Class Locator
//	  4. Click on CRM/SFA Link
//	  5. Click on Leads Button
//	  6. Click on Create Lead 
//	  7. Enter CompanyName Field Using id Locator
//	  8. Enter FirstName Field Using id Locator
//	  9. Enter LastName Field Using id Locator
//	  10. Enter FirstName(Local) Field Using id Locator
//	  11. Enter Department Field Using any Locator of Your Choice
//	  12. Enter Description Field Using any Locator of your choice 
//	  13. Enter your email in the E-mail address Field using the locator of your choice
//	  14. Select State/Province as NewYork Using Visible Text
//	  15. Click on Create Button
//              16. Get the Title of Resulting Page. refer the video  using driver.getTitle()
 
public class CreateLead extends AssignmentBaseClass {
//@Parameters({"url","username","password"})
   @Test
	public void create(){
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		String attribute = driver.findElement(By.id("createLeadForm_companyName")).getAttribute("value");
		System.out.println(attribute);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sai");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Ram");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Automation Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Welcome to the Automation");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("saikumaram@gmail.com");
		
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select states=new Select(state);
		states.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		
		

	}

}
