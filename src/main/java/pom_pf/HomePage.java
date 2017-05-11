package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[@class = ' ' and @href = '/signup/']")
	private WebElement signUp;

	@FindBy(xpath = "//a[@class = ' ' and @href = '/dashboard']")
	private WebElement logIn;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndClickButton_signUn")
	public WebElement findAndClickButton_signUn() {
		// signIn.click();
		wait.until(ExpectedConditions.elementToBeClickable(signUp)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return signUp;
	}

	@Step("findAndClickButton_logIn")
	public WebElement findAndClickButton_logIn() {
		// signIn.click();
		wait.until(ExpectedConditions.elementToBeClickable(logIn)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return logIn;
	}
}