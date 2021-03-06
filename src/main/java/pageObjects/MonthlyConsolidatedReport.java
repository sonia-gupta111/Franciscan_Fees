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

public class MonthlyConsolidatedReport {
	 WebDriver dr;
	 String r= "MonthlyConsolidatedReport";
	 
	 //By entrymode= By.id("ContentPlaceHolder1_lstentrymode");
	 By school= By.id("ContentPlaceHolder1_ddlSchool");
	 By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	 //By month= By.id("ContentPlaceHolder1_lstmonth");
	 //By cls= By.id("ContentPlaceHolder1_ddlStanard");
	 //By installment= By.id("ContentPlaceHolder1_lstInstallment");
	 By feehead= By.id("ContentPlaceHolder1_ddlFeeHeadToshown");
	 By paymode= By.id("ContentPlaceHolder1_lstPayMode");
	 By bankname= By.id("ContentPlaceHolder1_DDlDepBank");
	 By user= By.id("ContentPlaceHolder1_ddlUser");
	 By chequeclearingdate= By.id("ContentPlaceHolder1_chkclearingdate");
	 By headwise= By.id("ContentPlaceHolder1_rbtnShowCollection_0");
	 By withoutheadtotalamount= By.id("ContentPlaceHolder1_rbtnShowCollection_1");
	 By classwise= By.id("ContentPlaceHolder1_rbtnShowCollection_2");
	 By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
			 
	 public MonthlyConsolidatedReport(WebDriver d)
	  {
		  this.dr=d;
	  }
	  public void openMonthlyConsolidatedReport() throws InterruptedException
	  {
		  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
			 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(6000);
			 Actions builder= new Actions(dr);
			 builder.moveToElement(menu).build().perform();
			 WebElement submenu= dr.findElement(By.linkText("Collection"));
			 builder.moveToElement(submenu).build().perform();
			 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			 dr.findElement(By.linkText("Monthly Consolidated Report")).click();
			 dr.switchTo().frame(dr.findElement(By.id("Monthly Consolidated Report")));
	  }
	  public void selectEntryMode(String emode)
	  {
		 dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(5) > div > div > button")).click();
		 dr.findElement(By.cssSelector("body > div:nth-child(4) > div > ul > li:nth-child(2) > a")).click();
		 WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(emode.equals(option.getText()))
		  			option.click();
		 dr.findElement(By.cssSelector("body > div:nth-child(4) > div > ul > li.ui-multiselect-close")).click();
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
	  public void selectMonth(String m)
	  {
		//new Select(dr.findElement(month)).selectByVisibleText(m);
		dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(10) > div > button")).click();
		dr.findElement(By.cssSelector("body > div:nth-child(13) > div > ul > li:nth-child(2) > a")).click();
		WebElement select= dr.findElement(By.xpath("/html/body/div[10]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(m.equals(option.getText()))
	  			option.click();
		dr.findElement(By.cssSelector("body > div:nth-child(13) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectClass(String c)
	  {
		dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(3) > div > button")).click();
		dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li:nth-child(2) > a")).click();
		WebElement select= dr.findElement(By.xpath("/html/body/div[7]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(c.equals(option.getText()))
	  			option.click();
		dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectInstallment(String inst)
	  {
		dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(9) > div > button")).click();
		dr.findElement(By.cssSelector("body > div:nth-child(5) > div > ul > li:nth-child(2) > a")).click();
		WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
		dr.findElement(By.cssSelector("body > div:nth-child(5) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectFeeHead(String fhead)
	  {
	  	new Select(dr.findElement(feehead)).selectByVisibleText(fhead);
	  }
	  public void selectPayMode(String pmode)
	  {
		dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(7) > div > button")).click();
		dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2) > a")).click();
		WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(pmode.equals(option.getText()))
	  			option.click();
		dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectPayMode(String pmode1, String pmode2)
	  {
		  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(7) > div > button")).click();
			dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2) > a")).click();
			WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(pmode1.equals(option.getText())||pmode2.equals(option.getText()))
		  			option.click();
			dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectBankName(String bname)
	  {
		 dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(11) > div > button")).click();
		 dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
		 WebElement select= dr.findElement(By.xpath("/html/body/div[5]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(bname.equals(option.getText())||bname.equals(option.getText()))
		  			option.click();
		 dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectUser(String u)
	  {
		try {  
	 	   new Select(dr.findElement(user)).selectByVisibleText(u);
		}
		catch(NoSuchElementException e)
		{
		   new Select(dr.findElement(user)).selectByIndex(1);
		}
	  }
	  public void clickFilterWithChequeClearingDate()
	  {
		  dr.findElement(chequeclearingdate).click();
	  }
	  public void clickHeadWise()
	  {
		  dr.findElement(headwise).click();
	  }
	  public void clickWithOutHeadTotalAmount()
	  {
		  dr.findElement(withoutheadtotalamount).click();
	  }
	  public void clickClassWise()
	  {
		  dr.findElement(classwise).click();
	  }	  
	  public void clickShow(String schl,Collection<String>sc) throws InterruptedException, IOException  
	  {                                                                                                 
	      Utility u= new Utility();                                                                    
	      dr.findElement(show).click();
		  Utilities ut= new Utilities();
		  ut.verifyShow(dr,schl,r,sc);
	      Thread.sleep(10000);                                                                          
	      u.captureScreenshot(dr,schl,r,sc);                                                           
	      //u.downloadPDF(dr);
	  } 
}
