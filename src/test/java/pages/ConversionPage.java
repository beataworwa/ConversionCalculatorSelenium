package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionPage {

    private static final String BOOKMARK_PATTERN = "BOOKMARK";
    private static final String BOOKMARK_XPATH_PATTERN = "//a[contains(text(),'BOOKMARK')]";

    private static final By BY_FROM_VALUE = By.xpath("//input[@type='text' and @name='fromVal']");
    private static final By BY_FROM_METRICS_LIST = By.xpath("//select[@id='calFrom']");
    private static final By BY_TO_VALUE = By.xpath("//input[@type='text' and @name='toVal']");
    private static final By BY_TO_METRICS_LIST = By.xpath("//select[@id='calTo']");
    private static final By BY_SELECTED_BOOKMARK_XPATH_PATTERN = By.xpath("//li[@id='menuon']/a");

    private WebDriver webDriver;

    public ConversionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ConversionPage putFromValue(String fromValue) {
        WebElement fromValueField = webDriver.findElement(BY_FROM_VALUE);
        fromValueField.sendKeys(fromValue);
        return new ConversionPage(webDriver);
    }

    public ConversionPage selectFromMetric(String metricName) {
        WebElement fromMetricSelector = webDriver.findElement(BY_FROM_METRICS_LIST);
        Select fromList = new Select(fromMetricSelector);
        fromList.selectByVisibleText(metricName);
        return new ConversionPage(webDriver);
    }

    public ConversionPage selectToMetric(String metricName) {
        WebElement toMetricSelector = webDriver.findElement(BY_TO_METRICS_LIST);
        Select toList = new Select(toMetricSelector);
        List<WebElement> allElements = toList.getOptions();
        List<WebElement> properElements = allElements.stream().filter(webElement -> webElement.getText().startsWith(metricName)).collect(Collectors.toList());
        assertThat(properElements.size()).isEqualTo(1);
        toList.selectByVisibleText(properElements.get(0).getText());
        return new ConversionPage(webDriver);
    }

    public String getToValue() {
        WebElement toValueField = webDriver.findElement(BY_TO_VALUE);
        return toValueField.getAttribute("value");
    }

    public ConversionPage moveToBookmark(final String bookmarkName) {
        String xpathAfterReplace = BOOKMARK_XPATH_PATTERN.replace(BOOKMARK_PATTERN, bookmarkName);
        WebElement webElement = webDriver.findElement(By.xpath(xpathAfterReplace));
        webElement.click();
        return new ConversionPage(webDriver);
    }

    public String getTextFromSelectedBookmark() {
        WebElement webElement = webDriver.findElement(BY_SELECTED_BOOKMARK_XPATH_PATTERN);
        return webElement.getText();
    }
}
