import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


File html = new File("terrible.html")
URL url = html.toURI().toURL();
WebUI.openBrowser(url.toExternalForm());

WebUI.verifyElementPresent(makeTO("//h1[@id='main']"),3);

WebUI.switchToFrame(makeTO("//iframe[@id='CRMApplicationFrame']"), 5)

WebUI.verifyElementPresent(makeTO("//h1[@id='ch1']"), 5)

WebUI.switchToFrame(makeTO("//frame[@id='WorkAreaFrame1']"), 2)

WebUI.verifyElementPresent(makeTO("//h1[@id='content']"), 5)

WebUI.closeBrowser();


TestObject makeTO(String expr) {
	TestObject to = new TestObject(expr);
	to.addProperty("xpath", ConditionType.EQUALS, expr)
	return to
}