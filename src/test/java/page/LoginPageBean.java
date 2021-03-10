package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageBean {
	
	WebDriver driver;
	/*private By userName =By.name("customerId");
	private By userPwd=By.name("customerPwd");
	private By subLogin=By.name("login");*/
	
	@FindBy(name="customerId",how=How.NAME)
	private WebElement userName;
	
	@FindBy(name="customerPwd")
	private WebElement userPwd;
	
	@FindBy(id="login")
	private WebElement subLogin;
	
	//private By pageheading=By.xpath("//*[@id=\"mainCnt\"]/h1");
	//@FindBy(xpath="//*[@id=\"mainCnt\"]/h1")
	@FindBy(tagName = "h1")
	private WebElement pageheading;
	
	
	public LoginPageBean(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String usrName) {
		//driver.findElement(userName).sendKeys(usrName);
		userName.sendKeys(usrName);
	}
	
	
	public void setUserPwd(String usrPwd) {
		//driver.findElement(userPwd).sendKeys(usrPwd);
		userPwd.sendKeys(usrPwd);
	}
	
	public void setSubmitLogin() {
		//driver.findElement(subLogin).submit();
		subLogin.submit();
	}
	
	
	public String getPageTitle() {
		//return driver.findElement(pageheading).getText();
		return pageheading.getText();
	}

	
	
	public void loginTo_NextPage(String userName,
			String password) {
		this.setUserName(userName);
		this.setUserPwd(password);
		this.setSubmitLogin();
	}
	
	
	
}
