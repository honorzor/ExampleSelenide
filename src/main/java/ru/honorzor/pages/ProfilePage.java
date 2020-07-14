package ru.honorzor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {


    private SelenideElement newTestButton = $("[class = \"item_menu_logo new_test\"]");
    private SelenideElement fieldForNameTest = $("[data-testid  = \"Test name input\" ]");
    private SelenideElement fieldForAddressSite = $("[data-testid  = \"Address site input\" ]");
    private SelenideElement goToAuditButton = $("[data-testid  = \"Submit button\" ]");
    private SelenideElement fieldNamedSegment = $("[data-testid  = \"Segment name input 0\" ]");
    private SelenideElement toQuestButton = $("[data-testid  = \"Tasks button\" ]");
    private SelenideElement fieldAnswerVoice = $("[data-testid  = \"Tasks task question\" ]");
    private SelenideElement addAnswerButton = $("[data-testid  = \"Tasks submit task\" ]");
    private SelenideElement checkAndRunButton = $("[data-testid  = \"Check button\" ]");
    private SelenideElement runFreeTestButton = $("[data-testid  = \"Checkout start button\" ]");
    private SelenideElement successTextAfterRunTest = $("[class = \"sc-itybZL gLzIYc\"]");

    @Story("Create new test client from profile")
    public void createTest(String nameTest, String site, String segment, String answer) {
        clickNewTestButton();
        fillFieldNameTest(nameTest);
        fillFieldAddressSite(site);
        clickAuditButton();
        fillFieldNamedSegment(segment);
        clickQuestButton();
        fillFieldAnswer(answer);
        clickAddAnswer();
        clickCheckAndRun();
        clickRunFreeTest();
    }

    @Step("get actual text after successful created test")
    public String getTextAfter() {
        return successTextAfterRunTest.shouldBe(visible).getText();
    }

    @Step("click button run free test")
    public void clickRunFreeTest() {
        runFreeTestButton.shouldBe(visible).click();
    }

    @Step("click button check and run test")
    public void clickCheckAndRun() {
        checkAndRunButton.shouldBe(visible).click();
    }

    @Step("click button add answer")
    public void clickAddAnswer() {
        addAnswerButton.shouldBe(visible).click();
    }

    @Step("fill field answer voice")
    public void fillFieldAnswer(String answer) {
        fieldAnswerVoice.shouldBe(visible).setValue(answer);
    }

    @Step("click button quest")
    public void clickQuestButton() {
        toQuestButton.shouldBe(visible).click();
    }

    @Step("fill field name segment {0}")
    public void fillFieldNamedSegment(String segment) {
        fieldNamedSegment.shouldBe(visible).setValue(segment);
    }

    @Step("click button audit")
    public void clickAuditButton() {
        goToAuditButton.shouldBe(visible).click();
    }

    @Step("fill field address site {0}")
    public void fillFieldAddressSite(String site) {
        fieldForAddressSite.shouldBe(visible).setValue(site);
    }

    @Step("fill field name test {0}")
    public void fillFieldNameTest(String nameTest) {
        fieldForNameTest.shouldBe(visible).setValue(nameTest);
    }

    @Step("Click button 'NEW TEST'")
    public void clickNewTestButton() {
        newTestButton.shouldBe(visible).click();
    }
}
