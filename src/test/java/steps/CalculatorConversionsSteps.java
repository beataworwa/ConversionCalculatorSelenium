package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import config.SupportedBrowser;
import org.openqa.selenium.WebDriver;
import pages.ConversionPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorConversionsSteps {

    private static final String URL = "http://www.calculator.net/conversion-calculator.html";
    private WebDriver driver;

    @Given("^User run browser Chrome")
    public void run_browser_chrome() throws IllegalAccessException, InstantiationException {
        driver = DriverFactory.getDriver(SupportedBrowser.CHROME.name());

    }

    @Given("^User go to tested page$")
    public void go_to_main_page(){
        driver.get(URL);
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Conversion Calculator");
    }

    @When("^User move to bookmark '(.*)'$")
    public void move_to_bookmark(String bookmarkName) {
        ConversionPage conversionPage = new ConversionPage(driver);
        conversionPage.moveToBookmark(bookmarkName);
        String selectedBookmark = conversionPage.getTextFromSelectedBookmark();
        assertThat(selectedBookmark).isEqualTo(bookmarkName);
    }

    @When("^User put value '(.*)' in from field$")
    public void length_put_from_value(String value) {
        ConversionPage conversionPage = new ConversionPage(driver);
        conversionPage.putFromValue(value);
    }


    @When("^User select '(.*)' in source metrics tab$")
    public void selectMetricInFromTab(String sourceMetric) {
        ConversionPage conversionPage = new ConversionPage(driver);
        conversionPage.selectFromMetric(sourceMetric);
    }


    @When("^User select '(.*)' in destination metrics tab$")
    public void selectMetricInToTab(String destinationTab) {
        ConversionPage conversionPage = new ConversionPage(driver);
        conversionPage.selectToMetric(destinationTab);
    }

    @Then("^Value '(.*)'is displayed in to field$")
    public void verify_value_in_to_field(String expValue) {
        ConversionPage conversionPage = new ConversionPage(driver);
        assertThat(conversionPage.getToValue()).isEqualTo(expValue);
        DriverFactory.closeDriver();;
    }

}
