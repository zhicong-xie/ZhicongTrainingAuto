package gt.org.Steps.StorelletSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gt.org.Flow.StorelletFlow.LoginFlow;
import org.testng.Assert;

public class LoginSteps {

  private LoginFlow loginFlow;

  public LoginSteps() {
    loginFlow = new LoginFlow();
  }

  @Then("^the user in the Storellet login screen$")
  public void isLoginTitleDisplayed() {
    boolean expected = true;
    boolean actual = loginFlow.isLoginTitleDisplayed();
    String reason = "the Storellet login screen is not displayed";
    Assert.assertEquals(actual,expected,reason);
  }

  @Then("^the user in the Select area code partial modal")
  public void isSelectAreaCodeTitleDisplayed() {
    boolean expected = true;
    boolean actual = loginFlow.isSelectAreaCodeTitleDisplayed();
    String reason = "the Select area code partial modal is not displayed";
    Assert.assertEquals(actual,expected,reason);
  }
  @When(
      "^the user click (Setting|International area code|Forget password|Confirm|Create profile) button in the Storellet login screen$")
  public void clickButton(String buttonName) {
    switch (buttonName) {
      case "Setting":
        loginFlow.clickSettingButton();
        break;
      case "International area code":
        loginFlow.clickInternationalAreaCodeButton();
        break;
      case "Forget password":
        loginFlow.clickForgetPasswordButton();
        break;
      case "Confirm":
        loginFlow.clickConfirmButton();
        break;
      case "Create profile":
        loginFlow.clickCreateProfileButton();
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + buttonName);
    }
  }

  @When(
      "^the user select (.*) International area code in the Storellet login screen area code partial modal$")
  public void selectAreaCode(String areaCode) {
    loginFlow.selectInternationalAreaCode(areaCode);
  }

  @When("^the user input (.*) in the Storellet login screen (Phone number|Password) input box$")
  public void inputData(String data, String item) {
    switch (item) {
      case "Phone number":
        loginFlow.inputPhoneNumber(data);
        break;
      case "Password":
        loginFlow.inputPassword(data);
        break;
      default:
        throw new IllegalArgumentException("Illegal Argument : " + item);
    }
  }

    @Then("^the International area code able displayed (.*) in the Storellet login screen$")
    public void verifyAreaCode(String expected) {
        String actual = loginFlow.getInternationalAreaCode();
        String reason = String.format("the Area code displayed wrong; expected : %s, actual : %s",expected,actual);
        Assert.assertEquals(actual,expected,reason);
    }

  @Then("^the user in the Incorrect information partial modal")
  public void isIncorrectInformationTitleDisplayed() {
    boolean expected = true;
    boolean actual = loginFlow.isIncorrectInformationTitleDisplayed();
    String reason = "the Incorrect information partial modal is not displayed";
    Assert.assertEquals(actual,expected,reason);
  }

  @When("^the user click Confirm button in the Incorrect information partial modal$")
  public void clickIncorrectInformationConfirmButton() {
    loginFlow.clickIncorrectInformationConfirmButton();
  }
}
