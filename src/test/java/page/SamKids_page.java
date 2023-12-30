package page;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamKids_page 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div[2]/a[1]")
	WebElement admission_enquiry;
	@FindBy(xpath="/html/body/div[1]/div/div[2]/nav/div[1]/div/h1/a/img")
	WebElement logo;
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/nav/ul/li[2]/a")
	WebElement aboutus;
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/nav/ul/li[2]/div/a[1]")
	WebElement about;
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/nav/ul/li[2]/div/a[2]")
	WebElement blog;
	@FindBy(xpath="//*[@id=\"input-22\"]")
	WebElement name1;
	@FindBy(xpath="//*[@id=\"input-24\"]")
	WebElement time1;
	@FindBy(name="date")
	WebElement date1;
	@FindBy(name="father_name")
	WebElement fathername1;
	@FindBy(name="mother_name")
	WebElement mothername1;
	@FindBy(name="address")
	WebElement address1;
	@FindBy(name="mother_mail")
	WebElement email1;
	@FindBy(name="remarks")
	WebElement remarks1;
	@FindBy(name="mobno")
	WebElement phno1;
	@FindBy(name="soughtfor")
	WebElement soughtfor1;
	@FindBy(name="gender")
	WebElement gender1;
	@FindBy(name="centre")
	WebElement centre1;
	@FindBy(name="submit")
	WebElement submit1;
	
	
	public SamKids_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void title_verification()
	{
		String actualtitle=driver.getTitle();
		System.out.println("Actual Title is "+actualtitle);
		String expectedtitle="Best Preschool in Kochi | International Preschool Cochin | SAM Kids";
		if(actualtitle.equalsIgnoreCase(expectedtitle))
		{
			System.out.println("Title is verified!");
		}
		else
		{
			System.out.println("Title is incorrect");
		}
	}
	
	public void content_verification()
	{
		String content=driver.getPageSource();
		if(content.contains("Childhood"))
		{
			System.out.println("The page contains the word 'Childhood'");
		}
		else
		{
			System.out.println("The page does not contain the word 'Childhood'");
		}
	}
	
	public void logo_display()
	{
		boolean bn=logo.isDisplayed();
		if(bn)
		{
			System.out.println("Logo is displayed");
		}
		else
		{
			System.out.println("Logo is not displayed");
		}
	}
	
	public void aboutclick()
	{
		aboutus.click();
		about.click();
	}
	public void scrolldown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)","");
		System.out.println("Scrolled down Successfully!");
	}
	
	public void blogclick()
	{
		aboutus.click();
		blog.click();
		
		String currentURL=driver.getCurrentUrl();
		System.out.println("Current URL is "+currentURL);
		String expectedURL="https://hellosamkids.com/blog.php";
		if(currentURL.equals(expectedURL))
		{
			System.out.println("Current URL is same as Expected!!!");
		}
		else
		{
			System.out.println("Current URL is not same as Expected");
		}
		driver.navigate().back();
		driver.navigate().back();
	}
	
	public void admission_click()
	{
		admission_enquiry.click();
	}
	public void datadriven_name(String name) throws IOException
	{
		name1.sendKeys(name);
	}
	public void datadriven_time(String time)
	{
		time1.sendKeys(time);
	}
	public void datadriven_fathername(String fname)
	{
		fathername1.sendKeys(fname);
	}
	public void datadriven_mothername(String mname)
	{
		mothername1.sendKeys(mname);
	}
	public void datadriven_address(String address2)
	{
		address1.sendKeys(address2);
	}
	public void datadriven_email(String email2)
	{
		email1.sendKeys(email2);
	}
	public void datadriven_remark(String rmark)
	{
		remarks1.sendKeys(rmark);
	}
	public void date(String i)
	{
		date1.click();
		date1.sendKeys(i);
	}
	public void baldetails(String mobno,String soughtfor,String gender,String centre)
	{
		phno1.sendKeys(mobno);
		soughtfor1.sendKeys(soughtfor);
		gender1.sendKeys(gender);
		centre1.sendKeys(centre);
	}
	public void submitclick()
	{
		submit1.click();
		
		//Alert Handling
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println("Alert Text : "+alertText);
		alert.accept();
	}
	
	

}


