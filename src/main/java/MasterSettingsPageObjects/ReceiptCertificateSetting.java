package MasterSettingsPageObjects;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ReceiptCertificateSetting {
	WebDriver dr;
	Utility u= new Utility();
	String pg= "ReceiptCertificateSetting";
	
	public ReceiptCertificateSetting(WebDriver d)
	{
	   this.dr=d;
	   PageFactory.initElements(d, this);
	}
	public void openReceiptCertificateSetting()
	{
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("Receipt Certificate Setting")).click();
	   dr.switchTo().frame(dr.findElement(By.id("Receipt Certificate Setting")));
	}
	public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
	{
	   dr.findElement(By.xpath("//div[@class='content']")).click();
	   Thread.sleep(1000);
	   u.captureScreenshot(dr, schl, pg, sc);
	}
}
