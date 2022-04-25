package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends AssignmentBaseClass {
@Test
	public void edits() {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("SAI");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("RAM");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Kumar");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CSE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("WELCOME TCSier");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sairamkumar@tcs.com");
		
		WebElement eleCountry = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select elecoun= new Select(eleCountry);
		elecoun.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
	    driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("HI IM");
	    driver.findElement(By.name("submitButton")).click();
	    
	    String title = driver.getTitle();
	    System.out.println(title);
	}

}
