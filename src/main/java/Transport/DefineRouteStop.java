package Transport;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import MasterSettingsPageObjects.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

public class DefineRouteStop {
	WebDriver dr;
	Utilities u= new Utilities();
	String pg= "DefineRouteStop";

	@FindBy(id="ContentPlaceHolder1_ddlRouteNo")WebElement routeno;
	@FindBy(id="ContentPlaceHolder1_txtStopNo_TextBox")WebElement stopno;
	@FindBy(id="ContentPlaceHolder1_txtStopName_TextBox")WebElement stopname;
	@FindBy(id="ContentPlaceHolder1_BtnControls1_btnSave")WebElement save;
	@FindBy(id="ContentPlaceHolder1_BtnControls1_btnView")WebElement view;

	public DefineRouteStop(WebDriver d)
	{
	   this.dr=d;
	   PageFactory.initElements(d, this);
	}
	public void openDefineTransportMedium()
	{
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transport.png']"));
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("Define Route Stop")).click();
	   dr.switchTo().frame(dr.findElement(By.id("Define Route Stop")));
	   dr.findElement(By.xpath("//div[@class='floatleft twoOne']")).click();
	}
	public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
	{
	   Thread.sleep(1000);
	   u.captureScreenshot(dr, schl, pg, sc);
	}
	public void selectRouteNo(String  rno)
	{
		new Select(routeno).selectByVisibleText(rno);
	}
	public void enterStopNo(String sno)
	{
		stopno.sendKeys(sno);
	}
	public void enterStopName(String sname)
	{
		stopname.sendKeys(sname);
	}
	public void selectTransportGroup()
	{
		WebElement table= dr.findElement(By.id("example1"));
		List<WebElement>cells= table.findElements(By.tagName("th"));
		for(WebElement cell: cells)
		{
			new Select(dr.findElement(By.id("ContentPlaceHolder1_Allddlsdistance"))).selectByIndex(1);
		}
	}
	public void clickSave(String school, Collection<String> sc)throws IOException
	{
		save.click();
		u.verifySave(dr, school, pg, sc);
	}
	public void clickView(String school, Collection<String> sc)throws IOException
	{
		view.click();
		WebElement table= dr.findElement(By.id("example"));
		List<WebElement> cells= table.findElements(By.tagName("td"));
		if (cells.size()>1) {
			for (WebElement cell : cells) {
				cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptView')]")).click();
				break;
			}
		dr.findElement(By.id("ContentPlaceHolder1_BtnControls1_btnModify")).click();
		dr.findElement(By.id("popup_ok")).click();
		}else
			System.out.println("No record Found");
		u.verifyView(dr,school, pg, sc);
	}
}
