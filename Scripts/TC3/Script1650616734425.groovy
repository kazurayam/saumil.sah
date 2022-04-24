import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

File html = new File("terrible.html")

URL url = html.toURI().toURL();

WebUI.openBrowser(url.toExternalForm());

WebUI.verifyElementPresent(makeTO("//h1[@id='main']"),3);

WebUI.switchToFrame(makeTO("//iframe[@id='CRMApplicationFrame']"), 5)

WebUI.verifyElementPresent(makeTO("//h1[@id='ch1']"), 5)

WebDriver driver = DriverFactory.getWebDriver();

//driver.switchTo().defaultContent()
assert driver.findElement(By.tagName("frameset"))

/*
driver.switchTo()
		.frame(driver.findElements(By.tagName("frameset")).get(1))
		.frame(driver.findElements(By.tagName("frameset")).get(1))
		
WebElement e = driver.findElement(By.xpath("//h1[@id='content']"))
assert e != null
*/

WebUI.closeBrowser();


TestObject makeTO(String expr) {
	TestObject to = new TestObject(expr);
	to.addProperty("xpath", ConditionType.EQUALS, expr)
	return to
}