package gt.org.Steps.StorelletSteps;

import gt.org.Flow.StorelletFlow.WalletFlow;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class WalletSteps {

    private WalletFlow walletFlow;

    public WalletSteps() {
        walletFlow = new WalletFlow();
    }

    @Then("^the user in the Storellet wallet screen$")
    public void isWalletTitlePageDisplayed() {
        boolean expected = true;
        boolean actual = walletFlow.isWalletTitlePageDisplayed();
        String reason = "the user in the Storellet wallet screen";
        Assert.assertEquals(actual,expected,reason);
    }

}
