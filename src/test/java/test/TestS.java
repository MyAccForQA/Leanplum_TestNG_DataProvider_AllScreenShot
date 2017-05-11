package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom_pf.AccPage;
import pom_pf.HomePage;
import pom_pf.LogInPage;
import pom_pf.SignUpPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

@Title("TestS_Start")
@Description("Description")
public class TestS extends Test_BeforeAndAfter {

	// #1
	@Title("test_HomePage")
	@Test(groups = { "ff", "ok" })
	public void test_HomePage() {

		// ????????????????????????
		String exp = "The Mobile Marketing Platform | Leanplum";
		// ????????????????????????
		try {
			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePage - " + exp);
		}
	}

	// #2
	@Title("test_HomePageToGoLogIn")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoLogIn() {

		boolean exp = true;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage signInPF = new LogInPage(driver, wait);

			boolean act = signInPF.findButton_LogIn_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogIn " + exp);
		}
	}

	@DataProvider(name = "WrongEmail")
	public static String[][] wrongEmail() {
		String[][] str = { { "qwe", "qweasdzxc", "Please enter a valid email." },
				{ "qwe@", "qweasdzxc", "Please enter a valid email." },
				{ "qwe@asd", "qweasdzxc", "Please enter a valid email." },
				{ "qwe@asd.", "qweasdzxc", "Please enter a valid email." },
				{ "qwe@asd.c", "qweasdzxc", "Please enter a valid email." },
				{ "qwe@.com", "qweasdzxc", "Please enter a valid email." },
				{ "qwe@.", "qweasdzxc", "Please enter a valid email." } };
		return str;
	}

	// #3
	@Title("test_HomePageToGoLogIn_WrongEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongEmail")
	public void test_HomePageToGoLogIn_WrongEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage signInPF = new LogInPage(driver, wait);
			signInPF.findAndFillInField_Username(email);
			signInPF.findAndFillInField_Password(pass);
			signInPF.findAndClickButton_LogIn();

			String act = signInPF.findError_validEmailErr();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogIn_WrongEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "WrongPass")
	public static String[][] wrongPass() {
		String[][] str = { { "qwerty@asdf.com", "q", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qw", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qwe", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qwea", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qweas", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qweasd", "The password must be at least 8 characters." },
				{ "qwerty@asdf.com", "qweasdz", "The password must be at least 8 characters." } };
		return str;
	}

	// #4
	@Title("test_HomePageToGoLogIn_WrongPass_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongPass")
	public void test_HomePageToGoLogIn_WrongPass_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage signInPF = new LogInPage(driver, wait);
			signInPF.findAndFillInField_Username(email);
			signInPF.findAndFillInField_Password(pass);
			signInPF.findAndClickButton_LogIn();

			String act = signInPF.findError_validPassErr();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogIn_WrongPass_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "IncorrectEmail")
	public static String[][] incorrectEmail() {
		String[][] str = { { "qwerty@asdf.com", "qweasdzxc", "Check your email and password and try again." },
				{ "asdfgh@asdf.com", "qweasdzxc", "Check your email and password and try again." },
				{ "zxcvbn@asdf.com", "qweasdzxc", "Check your email and password and try again." } };
		return str;
	}

	// #5
	@Title("test_HomePageToGoLogIn_IncorrectEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "IncorrectEmail")
	public void test_HomePageToGoLogIn_IncorrectEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage signInPF = new LogInPage(driver, wait);
			signInPF.findAndFillInField_Username(email);
			signInPF.findAndFillInField_Password(pass);
			signInPF.findAndClickButton_LogIn();

			String act = signInPF.findError_checkEmailAndPass();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogIn_IncorrectEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	@DataProvider(name = "CorrectEmail")
	public static String[][] correctEmail() {
		String[][] str = { { "cufaza@envy17.com", "Zaq12wsx", "Qwe", "Asd", "Company", "415-748-0223",
				" has already been registered. Try to reset your password instead." } };
		return str;
	}

	// #6
	@Title("test_HomePageToGoLogIn_CorrectEmail")
	@Test(groups = { "ff", "ok" }, dataProvider = "CorrectEmail")

	public void test_HomePageToGoSignUp_CorrectEmail(String email, String pass, String fname, String lname, String comp,
			String phone, String must) {

		String exp = email + must;
		try {
			new HomePage(driver, wait).findAndClickButton_signUn();

			SignUpPage signUpPage = new SignUpPage(driver, wait);
			signUpPage.findAndFillInField_fName(fname);
			signUpPage.findAndFillInField_lName(lname);
			signUpPage.findAndFillInField_email(email);
			signUpPage.findAndFillInField_company(comp);
			signUpPage.findAndFillInField_phone(phone);
			signUpPage.findAndFillInField_Password(pass);
			signUpPage.findAndClickButton_buttonAccessNow();

			String act = signUpPage.findError_checkEmailAndPass();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogIn_CorrectEmail - " + email + ":" + pass + " = " + exp);
		}
	}

	// #7
	@Title("test_HomePageToGoLogIn_CorrectEmail")
	@Test(groups = { "ff", "ok" }, dataProvider = "CorrectEmail")
	public void test_HomePageToGoLogIn_CorrectEmail(String email, String pass, String fname, String lname, String comp,
			String phone, String must) {

		String exp = fname + " " + lname;
		try {
			new HomePage(driver, wait).findAndClickButton_logIn();

			LogInPage signInPF = new LogInPage(driver, wait);
			signInPF.findAndFillInField_Username(email);
			signInPF.findAndFillInField_Password(pass);
			signInPF.findAndClickButton_LogIn();

			AccPage accPage = new AccPage(driver, wait);

			String act = accPage.findAndFillInField_AccName();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogIn_CorrectEmail - " + email + ":" + pass + " = " + exp);
		}
	}
}