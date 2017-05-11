package pom_pf;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class SignUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@class = 'ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required' and @name = 'firstname']")
	private WebElement fname;
	
	@FindBy(xpath = "//input[@class = 'ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required' and @name = 'lastname']")
	private WebElement lname;

	// @FindBy(name = "email")
	@FindBy(xpath = "//input[@class = 'ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-valid-pattern']")
	private List<WebElement> username;

	@FindBy(xpath = "//input[@class = 'ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required' and @name = 'company']")
	private WebElement company;

	@FindBy(xpath = "//input[@class = 'ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required'  and @name = 'phone']")
	private WebElement phone;

	// @FindBy(name = "password")
	@FindBy(xpath = "//input[@class = 'ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-valid-minlength']")
	private List<WebElement> password;

	@FindBy(xpath = "//button[@class = 'button primary' and contains(text(), 'Access Now')]")
	private WebElement buttonAccessNow;

	@FindBy(xpath = "//div[@class = 'ng-binding']") // cufaza@envy17.com has
													// already been registered.
													// Try to reset your
													// password instead.
	private WebElement checkEmailAndPass;

	public SignUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndFillInField_fName with name - [{0}]")
	public WebElement findAndFillInField_fName(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(fname)).clear();
		wait.until(ExpectedConditions.visibilityOf(fname)).sendKeys(st);
		return fname;
	}

	@Step("findAndFillInField_lName with name - [{0}]")
	public WebElement findAndFillInField_lName(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(lname)).clear();
		wait.until(ExpectedConditions.visibilityOf(lname)).sendKeys(st);
		return lname;
	}

	@Step("findAndFillInField_Username with name - [{0}]")
	public WebElement findAndFillInField_email(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(username.get(0))).clear();
		wait.until(ExpectedConditions.visibilityOf(username.get(0))).sendKeys(st);
		return username.get(0);
	}

	@Step("findAndFillInField_company with name - [{0}]")
	public WebElement findAndFillInField_company(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(company)).clear();
		wait.until(ExpectedConditions.visibilityOf(company)).sendKeys(st);
		return company;
	}

	@Step("findAndFillInField_phone with name - [{0}]")
	public WebElement findAndFillInField_phone(String st) {
		// username.clear();
		wait.until(ExpectedConditions.visibilityOf(phone)).clear();
		wait.until(ExpectedConditions.visibilityOf(phone)).sendKeys(st);
		return phone;
	}

	@Step("findAndFillInField_Password with pass - [{0}]")
	public WebElement findAndFillInField_Password(String st) {
		// password.clear();
		wait.until(ExpectedConditions.visibilityOf(password.get(0))).clear();
		wait.until(ExpectedConditions.visibilityOf(password.get(0))).sendKeys(st);
		return password.get(0);
	}

	@Step("findButton_buttonAccessNow_isEnabled return boolean is isEnabled")
	public boolean findButton_buttonAccessNow_isEnabled() {
		return buttonAccessNow.isEnabled();
	}

	@Step("findButton_buttonAccessNow_isDisplayed return boolean is isDisplayed")
	public boolean findButton_buttonAccessNow_isDisplayed() {
		return buttonAccessNow.isDisplayed();
	}

	@Step("findAndClickButton_buttonAccessNow")
	public WebElement findAndClickButton_buttonAccessNow() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// buttonSignIn.click();
		wait.until(ExpectedConditions.visibilityOf(buttonAccessNow)).click();

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return buttonAccessNow;
	}

	@Step("findError_checkEmailAndPass return String - Error")
	public String findError_checkEmailAndPass() {
		return checkEmailAndPass.getText();
	}
}