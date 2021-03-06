package Transport;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MasterSettingsPageObjects.Utilities;
import org.openqa.selenium.support.ui.Select;

public class DefineVehicleRouteRelation {
	WebDriver dr;
	Utilities u= new Utilities();
	String pg= "DefineVehicleRouteRelation";

	@FindBy(id="ContentPlaceHolder1_ddlRouteNo")WebElement vehiclename;
	@FindBy(id="ContentPlaceHolder1_txtVehicleNo_TextBox")WebElement vehicleno;
	@FindBy(id="ContentPlaceHolder1_BtnControls1_btnSave")WebElement save;
	@FindBy(id="ContentPlaceHolder1_BtnControls1_btnView")WebElement view;

	public DefineVehicleRouteRelation(WebDriver d)
	{
	   this.dr=d;
	   PageFactory.initElements(d, this);
	}
	public void openDefineVehicleRouteRelation()
	{
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transport.png']"));
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("Define Vehicle Route Relation")).click();
	   dr.switchTo().frame(dr.findElement(By.id("Define Vehicle Route Relation")));
	   dr.findElement(By.xpath("//div[@class='float oneOne']")).click();
	}
	public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
	{
	   Thread.sleep(1000);
	   u.captureScreenshot(dr, schl, pg, sc);
	}
	public void clickSave(String school, Collection<String> sc)throws IOException
	{
		save.click();
		u.verifySave(dr, school, pg, sc);
	}
	public void selectVehicleName(String vname)throws InterruptedException
	{
		new Select(vehiclename).selectByVisibleText(vname);
		Thread.sleep(1000);
	}
	public void selectRoute()throws InterruptedException
	{
		WebElement table= dr.findElement(By.id("example1"));
		List<WebElement>cells= table.findElements(By.tagName("td"));
		if (cells.size()>1) {
		for (WebElement cell : cells) {
			if(cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptRoute_chkYesNo')]")).isSelected()){
				System.out.println("Route is already selected");
			}
			else
			cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptRoute_chkYesNo')]")).click();
			break;
		    }
	    }else
			System.out.println("No record Found");
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
