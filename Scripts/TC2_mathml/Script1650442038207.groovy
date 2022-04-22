import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


File html = new File("mathml.html")
URL url = html.toURI().toURL();
WebUI.openBrowser(url.toExternalForm());


List<String> candidates = [
	"/html/body",
	"//*[local-name()='math']"
	];
for (String locator in candidates) {
	TestObject to = makeTO(locator);
	WebUI.verifyElementPresent(to, 2, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.closeBrowser();


TestObject makeTO(String expr) {
	TestObject to = new TestObject(expr);
	to.addProperty("xpath", ConditionType.EQUALS, expr)
	return to
}