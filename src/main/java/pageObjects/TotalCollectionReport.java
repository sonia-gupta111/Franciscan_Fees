package pageObjects;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TotalCollectionReport {
WebDriver dr;
String r= "TotalCollectionReport";

   By school= By.id("ContentPlaceHolder1_ddlSchool");
   By cls= By.id("ContentPlaceHolder1_ddlStandard");
   By section=By.id("ContentPlaceHolder1_ddlSection");
   By feetype=By.id("ContentPlaceHolder1_ddlFeeType");
   By installment=By.id("ContentPlaceHolder1_ddlInstallment");
   By user= By.id("ContentPlaceHolder1_ddlUser");
   By show=By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
		   
   public TotalCollectionReport(WebDriver d)
   {
	   this.dr=d;
   }
   public void openTotalCollectionReport() throws InterruptedException
   {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
	 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Thread.sleep(5000);
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 WebElement submenu= dr.findElement(By.linkText("Collection"));
	 builder.moveToElement(submenu).build().perform();
	 dr.findElement(By.linkText("Total Collection Report")).click();
	 dr.switchTo().frame(dr.findElement(By.id("Total Collection Report")));		 
   }
   public void selectSchool(String s)
   {
	   Select sch=new Select(dr.findElement(school));
	   try {
	     sch.selectByVisibleText(s);
	   }
	   catch(NoSuchElementException e)
  	   {
   		sch.selectByIndex(1);
  	   }
   }
   public void selectClass(String s)
   {
	   Select c=new Select(dr.findElement(cls));
	   try {
	     c.selectByVisibleText(s);
	   }
	   catch(NoSuchElementException e)
  	   {
   		 c.selectByIndex(1);
  	   }
   }
   public void selectSection(String s)
   {
	   Select sec=new Select(dr.findElement(section));
	   try {
	     sec.selectByVisibleText(s);
	   }
	   catch(NoSuchElementException e)
  	   {
   		 sec.selectByIndex(1);
  	   }
   }
   public void selectFeeType(String s) throws InterruptedException
   {   Thread.sleep(2000);
	   Select ftype=new Select(dr.findElement(feetype));
	   try {
	     ftype.selectByVisibleText(s);
	   }
	   catch(NoSuchElementException e)
  	   {
   		ftype.selectByIndex(1);
  	   }
   }
   public void selectInstallment(String s) throws InterruptedException
   {   Thread.sleep(2000);
	   Select inst=new Select(dr.findElement(installment));
	   try {
	     inst.selectByVisibleText(s);
	   }
	   catch(NoSuchElementException e)
  	   {
   		 inst.selectByIndex(1);
  	   }
   }
   public void selectUser(String s)
   {
	   Select us=new Select(dr.findElement(user));
	   try {
	      us.selectByVisibleText(s);
	   }
	   catch(NoSuchElementException e)
  	   {
   		  us.selectByIndex(1);
  	   }
   }
   public void clickShow(String schl,Collection<String>sc) throws InterruptedException, IOException  
	{                                                                                                 
	   Utility u= new Utility();                                                                    
	   dr.findElement(show).click();                                                                
	   Thread.sleep(5000);                                                                          
	   u.captureScreenshot(dr,schl,r,sc);                                                           
	   u.downloadPDF(dr);                                                                           
	} 
}

