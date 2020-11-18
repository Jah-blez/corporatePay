package page;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Register_Page {
	private WebDriver driver = null;
	public static String projectpath= System.getProperty("user.dir");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	

	public Login_Register_Page (WebDriver driver) {

		this.driver  = driver;
	}
	public  WebDriver launchbrowser() throws Exception {
		
		
		
		System.setProperty("webdriver.gecko.driver", projectpath+ "\\driver\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		System.out.println("browser launched successfully");

		return driver;

	}
	
	public WebDriver log_page() throws Exception {
		workbook = new XSSFWorkbook(projectpath +"/files/details/upload.xlsx");
		sheet = workbook.getSheet("Sheet1");
		XSSFCell cell_url = sheet.getRow(0).getCell(0);

		String value = cell_url.getStringCellValue();

	    driver.get(value);
	    driver.findElement(By.xpath("//button[@class='ant-btn btn-alternate ant-btn-lg']")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("mich");
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div[2]")).click();
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Password77.");
	    driver.findElement(By.id("corporateCode")).click();
	    driver.findElement(By.id("corporateCode")).clear();
	    driver.findElement(By.id("corporateCode")).sendKeys("mich");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    String text = driver.findElement(By.xpath("//div[@id='root']/div/div/section/aside/div/ul/li/span[2]")).getText();
		System.out.println(text);
		assertEquals(text, "Dashboard");
	    return driver;
	}
public WebDriver reg_page() throws IOException, InterruptedException {
	workbook = new XSSFWorkbook(projectpath +"/files/details/upload.xlsx");
	sheet = workbook.getSheet("Sheet1");
	XSSFCell cell_url = sheet.getRow(0).getCell(0);

	String value = cell_url.getStringCellValue();

	  
	    driver.get(value);
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    
	    driver.findElement(By.id("corporateName")).sendKeys("Cross Ltd");
	    
	    driver.findElement(By.id("corporateEmail")).sendKeys("etutedap-9304@yopmail.com");
	    
	    driver.findElement(By.id("corporateCode")).sendKeys("cros");
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys("09088887777");
	    
	    driver.findElement(By.id("corporateAddress")).sendKeys("island");
	    driver.findElement(By.id("country")).click();
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[2]/div/div/div[3]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div[2]")).click();
	    
	    driver.findElement(By.id("adminName")).click();
	    driver.findElement(By.id("adminName")).clear();
	    driver.findElement(By.id("adminName")).sendKeys("Kaz Kose");
	    driver.findElement(By.id("adminUserName")).click();
	    driver.findElement(By.id("adminUserName")).clear();
	    driver.findElement(By.id("adminUserName")).sendKeys("cros");
	    driver.findElement(By.id("adminEmail")).click();
	    driver.findElement(By.id("adminEmail")).clear();
	    driver.findElement(By.id("adminEmail")).sendKeys("etutedap-9304@yopmail.com");
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    WebDriverWait wait = new WebDriverWait(driver, 1900);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[2]")));
		String text = driver.findElement(By.xpath("//div/span[2]")).getText();
		System.out.println(text);
		assertEquals(text, "Registration completed, kindly check your mail for credential");
	    
	    return driver;
	  
}
}
