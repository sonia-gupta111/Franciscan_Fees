package pageObjects;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import MasterSettingsPageObjects.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class YearlyCollectionReport {
WebDriver dr;
String r= "YearlyCollectionReport";

  By session= By.id("ContentPlaceHolder1_ddlAcadYear");
  By cls= By.id("ContentPlaceHolder1_ddlStanard");
  By section= By.id("ContentPlaceHolder1_ddlSection");
  By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
  By head= By.id("ContentPlaceHolder1_ddlFeeHeadToshown");
  By school= By.id("ContentPlaceHolder1_ddlSchool");
  By user= By.id("ContentPlaceHolder1_ddlUser");
  By filterwithchqclearingdate=By.id("ContentPlaceHolder1_chkclearingdate");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
  
  public YearlyCollectionReport(WebDriver d)
  {
	  this.dr=d;
  }
  public void openYearlyCollectionReport()
  {
	  WebElement menu;
   	  Actions builder= new Actions(dr);
   	  menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
      dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  builder.moveToElement(menu).build().perform();
	  builder.moveToElement(dr.findElement(By.linkText("Collection"))).build().perform();
	  WebElement menuop1= dr.findElement(By.linkText("Yearly Collection Report"));
	  menuop1.click();
	  dr.switchTo().frame(dr.findElement(By.id("Yearly Collection Report")));
  }
  public void selectEntryMode(String s)
  {
	  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(6) > div > div > button")).click();
	  dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2) > a")).click();
	  WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(s.equals(option.getText()))
	  			option.click();
	  dr.findElement(By.xpath("/html/body/div[4]/div/ul/li[3]")).click();
  }
  public void selectSession(String s)
  {
	  Select sess= new Select (dr.findElement(session));
	  try {
	    sess.selectByVisibleText(s);
	  }
	  catch(NoSuchElementException e)
	  {
	     new Select(dr.findElement(session)).selectByIndex(4);
	  }
  }
  public void selectClass(String s)
  {
	  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(4) > div > button")).click();
	  dr.findElement(By.cssSelector("body > div:nth-child(11) > div > ul > li:nth-child(2) > a")).click();
	  WebElement select= dr.findElement(By.xpath("/html/body/div[8]/ul"));
	  List<WebElement> options = select.findElements(By.tagName("span"));
	  for(WebElement option:options)
		  if(s.equals(option.getText()))
			  option.click();
	  dr.findElement(By.xpath("/html/body/div[8]/div/ul/li[3]")).click();
  }

  public void selectFeeType(String s)
  {
	  Select ftype= new Select(dr.findElement(feetype));
	  try {
	    ftype.selectByVisibleText(s);
	  }
	  catch(NoSuchElementException e)
	  {
	     ftype.selectByIndex(1);
	  }
  }
  public void selectHead(String s)
  {
	  Select h= new Select(dr.findElement(head));
	  h.selectByVisibleText(s);
  }
  public void selectSchool(String s)
  {
	  Select sch= new Select(dr.findElement(school));
	  try {
        sch.selectByVisibleText(s);
	  }
	  catch(NoSuchElementException e)
	  {
	    sch.selectByIndex(1);
	  }
  }
  public void selectPayMode(String p1, String p2)
  {
	  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(7) > div > button")).click();
	  dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
	  WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(p1.equals(option.getText())||p2.equals(option.getText()))
	  			option.click();
	  dr.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]")).click();
  }
  public void selectBankName(String s)
  {
	  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(11) > div > button")).click();
	  dr.findElement(By.cssSelector("body > div:nth-child(9) > div > ul > li:nth-child(2) > a")).click();
	  WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(s.equals(option.getText()))
	  			option.click();
	  dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[3]")).click();
  }
  public void selectUser(String s)
  {
	  Select usr= new Select(dr.findElement(user));
	  try {
	    usr.selectByVisibleText(s);
	  }
	  catch(NoSuchElementException e)
	  {
	     usr.selectByIndex(1);
	  }
  }
  public void checkFilterWithChqClearingDate()
  {
	  dr.findElement(filterwithchqclearingdate).click();
  }
  public void clickShow(String schl,Collection<String>sc) throws InterruptedException, IOException {
      Utility u = new Utility();
      dr.findElement(show).click();
      Utilities ut = new Utilities();
      ut.verifyShow(dr, schl, r, sc);
      sleep(5000);
      u.captureScreenshot(dr, schl, r, sc);
      //u.downloadPDF(dr);
  } 
}
