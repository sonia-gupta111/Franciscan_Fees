package pageObjects;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import MasterSettingsPageObjects.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BadDebtsReport {
	WebDriver dr;
	String r="BadDebtsReport";
	
	By feetype= By.name("ctl00$ContentPlaceHolder1$ddlFeeType");
	By cls= By.id("ContentPlaceHolder1_lstClass");
	By installment= By.id("ContentPlaceHolder1_ddlInstallment");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
	
	public BadDebtsReport(WebDriver d)
    {
	    this.dr=d;
    }
//open bad debts report	
    public void openBadDebtsReport() throws InterruptedException
    {
    	 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
         Thread.sleep(5000);
         Actions builder= new Actions(dr);
      	 builder.moveToElement(menu).build().perform();
         dr.findElement(By.linkText("Bad Debts Report")).click();
         dr.switchTo().frame(dr.findElement(By.id("Bad Debts Report")));
    }
//fee type    
    public void selectFeeType(String ftype) 
    {  
    	try {
    	  new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
    	}
    	catch(NoSuchElementException e)
        {
          new Select(dr.findElement(feetype)).selectByIndex(1);
        }
    }
//class    
    public void selectClass(String c)
    {
    	dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(2) > div > button")).click();
    	dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
    	WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(c.equals(option.getText()))
	  			option.click();
    	dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li.ui-multiselect-close")).click();
    }
//installment    
    public void selectInstallment(String inst)
    {
    	dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(3) > div > button")).click();
    	dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2) > a")).click();
    	WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
    	dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li.ui-multiselect-close")).click();
    }
//show    
    public void clickShow(String schl,Collection<String>sc) throws InterruptedException, IOException
    {
  	 Utility u= new Utility(); 
   	 dr.findElement(show).click();
   	 Utilities ut= new Utilities();
	 ut.verifyShow(dr,schl,r,sc);
   	 Thread.sleep(5000);
   	 u.captureScreenshot(dr,schl,r,sc);
   	 //u.downloadPDF(dr);
    }
}
