package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CreateProject;

public class ManageProject {

	WebDriver dr;
	CreateProject c=new CreateProject(dr);
	public ManageProject(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//*[@title='Manage Projects']/descendant::span[text()='Manage Projects']")
	private WebElement manageProject;
	
	@FindBy(xpath="//table/tbody/tr/td/div/div/div/a[text()='Kozey Solution']")
	private WebElement projectName;
	
	private void clickOnManageProject() {
		waitForElementClickable(manageProject);
		//manageProject.click();
		new Actions(dr).pause(5000).perform();
		new Actions(dr).click(manageProject).perform();
		}
	
	public boolean verifyProjectCreated() 
	{
		boolean b=false;
		clickOnManageProject();
		WebElement readName=dr.findElement(By.xpath("//table/tbody/tr/td/div/div/div/a[text()='"+c.readProjectName()+"']"));
		try {
			waitForElementVisible(readName);
			b=readName.isDisplayed();
		}catch(Exception e) {}
		return b;
		
	}
	
	public String getProjectNameFromApp() {
		return dr.findElement(By.xpath("//table/tbody/tr/td/div/div/div/a[text()='"+c.readProjectName()+"']")).getText();
	}
	public void waitForElementVisible(WebElement element) 
	{			
				WebDriverWait wait=new WebDriverWait(dr, 10);
				wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementClickable(WebElement element) 
	{
			WebDriverWait wait=new WebDriverWait(dr, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}

