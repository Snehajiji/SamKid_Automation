package test;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import base.Baseclass;
import page.SamKids_page;
import page.SamKids_page2;

public class SamKids_test extends Baseclass
{
	@Test
	public void test() throws IOException
	{
		SamKids_page ob=new SamKids_page(driver);
		SamKids_page2 ob1=new SamKids_page2(driver);
		
		ob.title_verification();
		ob.content_verification();
		ob.logo_display();
		ob.aboutclick();
		ob.scrolldown();
		ob.blogclick();
		ob.admission_click();

		try 
		{
            FileInputStream f = new FileInputStream("D:\\A Software Testing\\Project\\SamKids_Automation\\Kid_details.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(f);
            XSSFSheet sh = wb.getSheet("Sheet1");

            if (sh != null) 
            {
                int row = sh.getLastRowNum();
                for (int i=1;i<=row;i++) 
                {
                    String kidname = sh.getRow(i).getCell(0).getStringCellValue();
                    System.out.println(kidname);
                    String preferredtime=sh.getRow(i).getCell(1).getStringCellValue();
                    System.out.println(preferredtime);
                    String fathername=sh.getRow(i).getCell(2).getStringCellValue();
                    System.out.println(fathername);
                    String mothername=sh.getRow(i).getCell(3).getStringCellValue();
                    System.out.println(mothername);
                    String address=sh.getRow(i).getCell(4).getStringCellValue();
                    System.out.println(address);
                    String email=sh.getRow(i).getCell(5).getStringCellValue();
                    System.out.println(email);
                    String remarks=sh.getRow(i).getCell(6).getStringCellValue();
                    System.out.println(remarks);
                    
                  
                    ob.datadriven_name(kidname);
                    ob.datadriven_time(preferredtime);
                    ob.datadriven_fathername(fathername);
                    ob.datadriven_mothername(mothername);
                    ob.datadriven_address(address);
                    ob.datadriven_email(email);
                    ob.datadriven_remark(remarks);
                }
            } 
            else 
            {
                System.out.println("Sheet not found in the Excel file.");
            }
            f.close();
            wb.close();
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		ob.date("13012020");
		ob.baldetails("1234456781", "LKG", "Female", "Kakkanad");
		ob.submitclick();
		
		driver.navigate().back();
		driver.navigate().back();
		
		ob1.mousehover();
		ob1.screenshot();
		ob1.scrollUp();
		ob1.handle_multipletab();
	
	}
	@AfterTest
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	

}
