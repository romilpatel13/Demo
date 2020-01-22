package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	private WebDriver dr;
	public LoginPage(WebDriver driver){
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="[name='username']")
	private WebElement user;
	
	@FindBy(css="[name='password']")
	private WebElement pass;
	
	@FindBy(css="button[type='submit'] > span")
	private WebElement submit;
	
	
	
	public void loginToApplication(String username, String password)
	{
		waitForElementVisible(user);
		user.sendKeys(username);
		pass.sendKeys(password);
		submit.click();
	}
	
public void waitForElementClickable(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
public void waitForElementVisible(WebElement element) {
	
	WebDriverWait wait=new WebDriverWait(dr, 10);
	wait.until(ExpectedConditions.visibilityOf(element));
}
}
