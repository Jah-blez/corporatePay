package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import page.Login_Register_Page;


public class Login {
	static WebDriver driver;
	
	public static Connection connObj;
	public static String emailfordatabase1;
	private static CharSequence passHash = null;
	private static CharSequence secureStamp = null;
	
	static Statement stmt = null;
	public static String JDBC_URL = "jdbc:sqlserver://www.skillbeta.com.ng:4489;databaseName=CorporatePayment-V2";
	@Test
public static void logintest() throws Exception {
	Login_Register_Page lr = new Login_Register_Page(driver);
	driver =lr.launchbrowser();
	lr.reg_page();
	//lr.log_page();
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	connObj = DriverManager.getConnection(JDBC_URL, "NAMBValidator2", "");


	stmt = connObj.createStatement();
	String sql_select_password_hash;
	String sql_select_securtiy_stamp;
	String sql_update_password_hash;
	String sql_update_security_stamp;
	

	sql_select_password_hash= " SELECT *  FROM [CorporatePayment-V1].[dbo].AspNetUsers where Email= 'm4mariaoni2@yahoo.com";
	//sql_select_securtiy_stamp= "SELECT *  FROM [uat_quickteller].[dbo].[UsersExtraData] where Username='"+emailfordatabase1+"'";
	sql_update_password_hash= "SELECT *  FROM [uat_quickteller].[dbo].[UsersExtraData] where Username='"+emailfordatabase1+"'";
	//sql_update_security_stamp= "SELECT *  FROM [uat_quickteller].[dbo].[UsersExtraData] where Username='"+emailfordatabase1+"'";



	ResultSet rs = stmt.executeQuery(sql_select_password_hash);
	//ResultSet rs_SS = stmt.executeQuery(sql_select_securtiy_stamp);


	while(rs.next()) {
		String passwordHash  = rs.getString("PasswordHash");
		passHash= passwordHash;
		String securityStamp  = rs.getString("SecurityStamp");
		secureStamp= securityStamp;
		
		
	}

	//SignUpRep.activation(code);



	System.out.println("account has been successfully created and activated");

	Thread.sleep(5000);

	//sql_delete= "Delete FROM [uat_quickteller].[dbo].[UsersExtraData] where Username='"+emailfordatabase1+"'";
	
//	sql_delete_1 = "Delete from  aspnet_Membership WHERE (Email='lima@test.com')";
//	
//	sql_delete_2="delete from aspnet_UsersInRoles WHERE  userid = (select userid from aspnet_Users where  UserName= 'lima@test.com')";
//	sql_delete_3 = "delete FROM [uat_quickteller].[dbo].[aspnet_Users]   where UserName = 'lima@test.com'";
	
	//stmt.executeUpdate(sql_delete);
	//System.out.println("email is deleted");


}
	@AfterTest
	public static void teardown() {
		driver.close();
	}
}
