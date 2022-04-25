package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

///*
// * //Pseudo Code
// * 
// * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
// * 
// * 2. Enter UserName and Password Using Id Locator
// * 
// * 3. Click on Login Button using Class Locator
// * 
// * 4. Click on CRM/SFA Link
// * 
// * 5. Click on contacts Button
// * 
// * 6. Click on Create Contact
// *  
// * 7. Enter FirstName Field Using id Locator
// * 
// * 8. Enter LastName Field Using id Locator
// * 
// * 9. Enter FirstName(Local) Field Using id Locator
// * 
// * 10. Enter LastName(Local) Field Using id Locator
// * 
// * 11. Enter Department Field Using any Locator of Your Choice
// * 
// * 12. Enter Description Field Using any Locator of your choice 
// * 
// * 13. Enter your email in the E-mail address Field using the locator of your choice
// * 
// * 14. Select State/Province as NewYork Using Visible Text
// * 
// * 15. Click on Create Contact
// * 
// * 16. Click on edit button 
// * 
// * 17. Clear the Description Field using .clear
// * 
// * 18. Fill ImportantNote Field with Any text
// * 
// * 19. Click on update button using Xpath locator
// * 
// * 20. Get the Title of Resulting Page.
public class CreateContact extends AssignmentBaseClass{
    @Test
	public void creatContact() {
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver=new ChromeDriver();
//		driver.get("http://leaftaps.com/opentaps/control/login");
//		driver.manage().window().maximize();
//		driver.findElement(By.id("username")).sendKeys("DemoCSR");
//		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		driver.findElement(By.className("decorativeSubmit")).click();
//		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.xpath("//input[@id='firstNameField'][@name='firstName']")).sendKeys("Priya");
		driver.findElement(By.id("lastNameField")).sendKeys("kumari");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Priya");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Kumari");
		driver.findElement(By.id("createContactForm_description")).sendKeys("WelCome to world");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("priya@yahoo.com");
		WebElement states = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
        Select state=new Select(states);
        state.selectByVisibleText("New York");
        driver.findElement(By.name("submitButton")).click();
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("updateContactForm_description")).clear();
        driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important here");
        driver.findElement(By.xpath("//input[@name='submitButton'][@value='Update']")).click();
        String title = driver.getTitle();
        System.out.println(title);
        
        
	}

}

