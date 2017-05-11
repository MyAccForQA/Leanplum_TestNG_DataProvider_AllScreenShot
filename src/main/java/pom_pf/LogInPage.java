package pom_pf;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class LogInPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// @FindBy(name = "email")
	@FindBy(xpath = "//input[@class = 'ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-valid-pattern']")
	private List<WebElement> username;

	// @FindBy(name = "password")
	@FindBy(xpath = "//input[@class = 'ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-valid-minlength']")
	private List<WebElement> password;

	@FindBy(xpath = "//button[@class = 'button primary' and contains(text(), 'Log in')]")
	private WebElement buttonLogIn;

	@FindBy(xpath = "//div[@class = '' and contains(text(), 'Please enter a valid email.')]")
	private WebElement validEmailErr;

	@FindBy(xpath = "//div[@class = '' and contains(text(), 'The password must be at least 8 characters.')]")
	private WebElement validPassErr;

	@FindBy(xpath = "//div[@class = 'ng-binding']") // Check your email and
													// password and try again.
	private WebElement checkEmailAndPass;

	public LogInPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndFillInField_Username with name - [{0}]")
	public WebElement findAndFillInField_Username(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(username.get(1))).clear();
		wait.until(ExpectedConditions.visibilityOf(username.get(1))).sendKeys(st);
		return username.get(1);
	}

	@Step("findAndFillInField_Password with pass - [{0}]")
	public WebElement findAndFillInField_Password(String st) {
		// password.clear();
		wait.until(ExpectedConditions.visibilityOf(password.get(1))).clear();
		wait.until(ExpectedConditions.visibilityOf(password.get(1))).sendKeys(st);
		return password.get(1);
	}

	@Step("findButton_LogIn_isEnabled return boolean is isEnabled")
	public boolean findButton_LogIn_isEnabled() {
		return buttonLogIn.isEnabled();
	}

	@Step("findButton_LogIn_isDisplayed return boolean is isDisplayed")
	public boolean findButton_LogIn_isDisplayed() {
		return buttonLogIn.isDisplayed();
	}

	@Step("findAndClickButton_LogIn")
	public WebElement findAndClickButton_LogIn() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// buttonSignIn.click();
		wait.until(ExpectedConditions.visibilityOf(buttonLogIn)).click();

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return buttonLogIn;
	}

	@Step("findError_validEmailErr return String - Error")
	public String findError_validEmailErr() {
		return validEmailErr.getText();
	}

	@Step("findError_validPassErr return String - Error")
	public String findError_validPassErr() {
		return validPassErr.getText();
	}

	@Step("findError_checkEmailAndPass return String - Error")
	public String findError_checkEmailAndPass() {
		return checkEmailAndPass.getText();
	}
}