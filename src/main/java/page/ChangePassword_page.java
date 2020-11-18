package page;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword_page {
private WebDriver driver= null;
public static String projectpath= System.getProperty("user.dir");
static XSSFWorkbook workbook;
static XSSFSheet sheet;
	public ChangePassword_page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebDriver first_time_user_changepassword () throws IOException {
		workbook = new XSSFWorkbook(projectpath +"/files/details/upload.xlsx");
		sheet = workbook.getSheet("Sheet1");
		XSSFCell cell_url = sheet.getRow(0).getCell(0);

		String value = cell_url.getStringCellValue();

		driver.get(value);
		driver.findElement(By.xpath("//button[@class='ant-btn btn-alternate ant-btn-lg']")).click();
		

	    driver.findElement(By.id("username")).sendKeys("josh");
	
	    driver.findElement(By.id("password")).sendKeys("!3z1rQ0S");
	
	    driver.findElement(By.id("corporateCode")).sendKeys("josh");
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    
	    driver.findElement(By.id("corporateCode")).sendKeys("josh");
	    
	    driver.findElement(By.id("oldPassword")).clear();
	    driver.findElement(By.id("oldPassword")).sendKeys("!3z1rQ0S");
	    
	    
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Password77.");
	    
	    driver.findElement(By.id("confirmPassword")).clear();
	    driver.findElement(By.id("confirmPassword")).sendKeys("Password77.");
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("josh");
	    
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Password77.");
	    
	    driver.findElement(By.id("corporateCode")).clear();
	    driver.findElement(By.id("corporateCode")).sendKeys("josh");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		return driver;
	}
	
	public WebDriver user_changepassword () throws Exception {
		Login_Register_Page log = new Login_Register_Page(driver);
		log.log_page();
		
		driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-circle']")).click();
		driver.findElement(By.xpath("//p[contains(text(),'Change Password')]")).click();
		
	    
	    driver.findElement(By.id("corporateCode")).sendKeys("josh");
	    
	    driver.findElement(By.id("oldPassword")).clear();
	    driver.findElement(By.id("oldPassword")).sendKeys("Password77.");
	    
	    
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Password77!");
	    
	    driver.findElement(By.id("confirmPassword")).clear();
	    driver.findElement(By.id("confirmPassword")).sendKeys("Password77!");
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		return driver;
	}
	
}
