package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AttributeAssignment extends BaseClass {
	@Test(priority = 4,groups={"Leads"})
	public void create() {

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
		Select states = new Select(state);
		states.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(priority = 1,groups= {"Contacts"})
	public void creatContact() {
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.xpath("//input[@id='firstNameField'][@name='firstName']")).sendKeys("Priya");
		driver.findElement(By.id("lastNameField")).sendKeys("kumari");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Priya");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Kumari");
		driver.findElement(By.id("createContactForm_description")).sendKeys("WelCome to world");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("priya@yahoo.com");
		WebElement states = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select state = new Select(states);
		state.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important here");
		driver.findElement(By.xpath("//input[@name='submitButton'][@value='Update']")).click();
		String title = driver.getTitle();
		System.out.println(title);

	}
	@Test(invocationCount = 2,groups= {"Leads"})
	public void viewLeadMail() {
		System.out.println("Please Login and View the details");
	}

	@Test(enabled = false,groups= {"Contacts"})
	public void createEmail() {
		System.out.println("Create Email is optional");
	}

	@Test(priority = 2,dependsOnMethods="create",groups= {"Leads"})
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
		Select elecoun = new Select(eleCountry);
		elecoun.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("HI IM");
		driver.findElement(By.name("submitButton")).click();

		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(priority = 3,groups= {"Contacts"})
	public void merge() throws InterruptedException {
		// TODO Auto-generated method stub

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.linkText("Merge Contacts")).click();

		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdFrom']/following::img[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String secondWindow = list.get(1);
		driver.switchTo().window(secondWindow);
		driver.findElement(By.xpath("(//td[contains(@class,'td-partyId')]//a)[2]")).click();
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdFrom']/following::img[2]")).click();
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandle);
		String secondWindow1 = list1.get(1);
		driver.switchTo().window(secondWindow1);
		driver.findElement(By.xpath("(//td[contains(@class,'td-partyId')]//a)[3]")).click();
		driver.switchTo().window(list1.get(0));
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println("The title is : " + title);
		if (title.contains("View Contact"))
			System.out.println("Title matches");
		else
			System.out.println("Not matching Title");
	}

	@Test(priority = 5,groups= {"Contacts"})
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
