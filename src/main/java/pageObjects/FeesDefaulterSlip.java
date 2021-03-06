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

public class FeesDefaulterSlip {
   WebDriver dr;
   String r="FeesDefaulterSlip";
   
     By school= By.id("ContentPlaceHolder1_ddlSchool");
     By cls= By.id("ContentPlaceHolder1_ddlStandard");
     By section= By.id("ContentPlaceHolder1_ddlSection");
     By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
     By daterange= By.id("ContentPlaceHolder1_chkrange");
     By fromdate= By.name("ctl00$ContentPlaceHolder1$txtDateFrom$TextBox");
     By tilldate= By.name("ctl00$ContentPlaceHolder1$txtDateTo$TextBox");
     By withfine= By.id("ContentPlaceHolder1_ChkIsFine");
     By show= By.name("ctl00$ContentPlaceHolder1$btnShow$ctl00");
     
     public FeesDefaulterSlip(WebDriver d)
     {
    	 this.dr=d;
     }
     public void openFeesDefaulterSlip() throws InterruptedException
     {
    	 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //Thread.sleep(1000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Fee Defaulter"));
		 builder.moveToElement(submenu).build().perform();
		 dr.findElement(By.linkText("Fees Defaulter Slip")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Fees Defaulter Slip")));		
     }
     public void selectSchool(String sch)
     {
    	 try {
    	   new Select(dr.findElement(school)).selectByVisibleText(sch);
    	 }
    	 catch(NoSuchElementException e)
  	     {
  		   new Select(dr.findElement(school)).selectByIndex(1);
  	     }
     }
     public void selectClass(String c) throws InterruptedException
     {
    	 try {
    	    new Select(dr.findElement(cls)).selectByVisibleText(c);
    	 }
    	 catch(NoSuchElementException e)
  	     {
  		   new Select(dr.findElement(cls)).selectByIndex(1);
  	     }
    	 Thread.sleep(1000);
     }
     public void selectSection(String sec)
     {
    	 try {
    	    new Select(dr.findElement(section)).selectByVisibleText(sec);
    	 }
    	 catch(NoSuchElementException e)
  	     {
  		   new Select(dr.findElement(section)).selectByIndex(1);
  	     }
     }
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
     public void selectInstallment(String inst)
     {
    	dr.findElement(By.xpath("//button[@type='button']")).click();
 		dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
 		WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
 		List<WebElement> options = select.findElements(By.tagName("span"));
 	  	for(WebElement option:options)
 	  		if(inst.equals(option.getText()))
 	  			option.click();
        dr.findElement(By.xpath("//a[@class='ui-multiselect-close']")).click();
     }
     public void clickDateRange()
     {
    	 dr.findElement(daterange).click();
     }
     public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
     {
     	 dr.findElement(fromdate).click();
 	  	  Thread.sleep(500);
 	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
 	      Thread.sleep(200);
 	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
 	  	  Thread.sleep(200);
 	  	  WebElement myw=dr.findElement(By.className("datepick"));
 	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
 	  		  for(WebElement cell: cells) {
 	  			if (cell.getText().equals(dd)){  
 	  			cell.click();
 	  			break; 
 	  		 }  
 	    }Thread.sleep(500);
     }   
     public void selectTillDate(String mm, String yy, String dd) throws InterruptedException
     {
    	 dr.findElement(tilldate).click();
	  	  Thread.sleep(500);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(200);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(200);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			cell.click();
	  			break; 
	  		 }  
	    }Thread.sleep(500);
     }
     public void clickWithFine()
     {
    	 dr.findElement(withfine).click();
     }
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
