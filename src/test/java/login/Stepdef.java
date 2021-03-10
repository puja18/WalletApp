package login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	
	private WebDriver driver;
	private WebElement element;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\vidavid\\selenium\\chromedriver.exe");
	
		driver=new ChromeDriver();
		
		
	}
	
	@Given("^Open login page$")
	public void open_login_page() throws Throwable {
	    driver.get("http://localhost:8081/WalletApp");
	}

	@When("^Username and password valid$")
	public void username_and_password_valid() throws Throwable {
		element=driver.findElement(By.name("customerId"));
		element.sendKeys("1");
		
		element=driver.findElement(By.name("customerPwd"));
		element.sendKeys("tom123");
		
		element.submit();
		
	}

	@Then("^Navigate to main page$")
	public void navigate_to_main_page() throws Throwable {
	    
		String url=driver.getCurrentUrl();
		assertTrue(url.equals("http://localhost:8081/WalletApp/validateLogin"));
		
	}
	
	@After
	public void tearDown() {
		driver.close();
	}


}
