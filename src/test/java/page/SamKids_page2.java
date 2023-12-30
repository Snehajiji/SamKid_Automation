package page;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamKids_page2 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"about\"]/div/div/div[1]/div/div")
	WebElement curriculum;
	@FindBy(xpath="//*[@id=\"about\"]/div/div/div[2]/div/div")
	WebElement Nusery1;
	@FindBy(xpath="//*[@id=\"about\"]/div/div/div[3]/div/div")
	WebElement Nusery2;
	@FindBy(xpath="//*[@id=\"about\"]/div/div/div[4]/div/div/h5")
	WebElement Nusery3;
	@FindBy(xpath="/html/body/div[1]/div/div[2]/nav/div[1]/div/h1/a/img")
	WebElement logo;
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/nav/ul/li[6]/a")
	WebElement mediacentre;
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/nav/ul/li[6]/div/a[2]")
	WebElement newsletter;
	@FindBy(xpath="/html/body/div[3]/div/div/a[2]/center/img")
	WebElement newsletter_january;
	
	
	
	public SamKids_page2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void mousehover()
	{
		Actions action=new Actions(driver);
		action.moveToElement(curriculum);
		action.moveToElement(Nusery1);
		action.moveToElement(Nusery2);
		action.moveToElement(Nusery3);
		action.perform();
	
	}
	public void screenshot() throws IOException
	{
		//Screenshot of an element (logo)
		File f=logo.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("./Screenshot/SamKids.png"));
		
		//Screenshot of the page
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/homepage.png"));
		
	}
	public void scrollUp()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,0);");
		System.out.println("Scrolled Up Successfully!");
		
	}
	public void handle_multipletab()
	{
		mediacentre.click();
		newsletter.click();
		String parentwindow=driver.getWindowHandle();
		newsletter_january.click();
		Set<String>allwindowhandles=driver.getWindowHandles();
		for(String handle:allwindowhandles)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
				driver.close();
			}
			driver.switchTo().window(parentwindow);
		}
	}
	

}
