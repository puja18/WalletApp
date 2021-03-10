package login;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.LoginPageBean;

public class LoginPageTest {

	private WebDriver driver;
	private LoginPageBean loginPageBean;
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\vidavid\\selenium\\chromedriver.exe");
	
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		loginPageBean=new LoginPageBean(driver);
	}
	
	@Test
	public void  check_loginpage_naviagation() {
		driver.get("http://localhost:8080/WalletApp");
		String pageHeading=loginPageBean.getPageTitle().trim();
		
		assertTrue(pageHeading.equals("Capg Banking Application"));

		
		loginPageBean.loginTo_NextPage("1", "tom123");
		
	}
	
	
	@After
	public void tearDown() {
		driver.close();
	}
	

}
