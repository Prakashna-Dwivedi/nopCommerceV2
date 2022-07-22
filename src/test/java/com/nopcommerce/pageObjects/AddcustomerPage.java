package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

	  public WebDriver ldriver;
	  
	 public AddcustomerPage(WebDriver rdriver)
	  {
		  ldriver=rdriver;
		  PageFactory.initElements(rdriver,this);
	  }
	  
	  By lnkCustomers_menu=By.xpath("//p[contains(text(),'Customers')]//i[@class='right fas fa-angle-left ']");
	  By lnkCustomers_menuitem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");

	  By btnAddnew=By.xpath("//a[starts-with(@class,'btn btn-primary')]"); 
	  
		By txtEmail=By.xpath("//input[@id='Email']");
		By txtPassword=By.xpath("//input[@id='Password']");

		By txtFirstName=By.xpath("//input[@id='FirstName']");
		By txtLastName=By.xpath("//input[@id='LastName']");

		By rdMaleGender=By.id("Gender_Male");
		By rdFeMaleGender=By.id("Gender_Female");
		
		By txtDob=By.xpath("//input[@id='DateOfBirth']");
		
		By txtCompanyName=By.xpath("//input[@id='Company']");

		By txtcustomerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
		
		By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
		By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
		By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
		By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
		
		
		
		By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
		
			
		By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
		
		By btnSave=By.xpath("//button[@name='save']");
		
		
		public void clickOnCustomersMenu() throws InterruptedException{
			Thread.sleep(1000);
			ldriver.findElement(lnkCustomers_menu).click();
		}

		public void clickOnCustomersMenuItem() throws InterruptedException {
			ldriver.findElement(lnkCustomers_menuitem).click();
			Thread.sleep(2000);
		}
		
		public void clickOnAddnew() throws InterruptedException {
			ldriver.findElement(btnAddnew).click();
			Thread.sleep(2000);
		}
		
		public void setEmail(String email) throws InterruptedException
		{
			ldriver.findElement(txtEmail).sendKeys(email);
			Thread.sleep(1000);
		}
		
		public void setPassword(String password)
		{
			ldriver.findElement(txtPassword).sendKeys(password);
		}
		
		
		public void setCustomerRoles(String role) throws InterruptedException 
			{
			Thread.sleep(1000);
				ldriver.findElement(By.xpath("//span[@title='delete']")).click();
			
				ldriver.findElement(txtcustomerRoles).click();
							
				WebElement listitem;
				
				switch(role)
				{
				case "Administrators":
						listitem=ldriver.findElement(lstitemAdministrators); break;
				case "Guests":
						listitem=ldriver.findElement(lstitemGuests); break;
				case "Registered":
					listitem=ldriver.findElement(lstitemRegistered); break;
				case "Vendors":
					listitem=ldriver.findElement(lstitemVendors); break;
				default:
					listitem=ldriver.findElement(lstitemGuests);
				}
							
				JavascriptExecutor js = (JavascriptExecutor)ldriver;
				js.executeScript("arguments[0].click();", listitem);
				
		}

		public void setManagerOfVendor(String value)
		{
			Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
			drp.selectByVisibleText(value);
		}
		
		public void setGender(String gender)
		{
			if(gender.equals("Male"))
			{
				ldriver.findElement(rdMaleGender).click();
			}
			else if(gender.equals("Female"))
			{
				ldriver.findElement(rdFeMaleGender).click();
			}
			else
			{
				ldriver.findElement(rdMaleGender).click();//Default
			}
			
		}
		
		public void setFirstName(String fname)
		{
			ldriver.findElement(txtFirstName).sendKeys(fname);
		}
		
		public void setLastName(String lname)
		{
			ldriver.findElement(txtLastName).sendKeys(lname);
		}
		
		public void setDob(String dob)
		{
			ldriver.findElement(txtDob).sendKeys(dob);
		}
		
		public void setCompanyName(String comname)
		{
			ldriver.findElement(txtCompanyName).sendKeys(comname);
		}
		
		public void setAdminContent(String content) 
		{
			ldriver.findElement(txtAdminContent).sendKeys(content);
		}
		
		public void clickOnSave() throws InterruptedException
		{
			Thread.sleep(1000);
			ldriver.findElement(btnSave).click();
			Thread.sleep(1000);
		}
}
