import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


File html = new File("Unified Lead_ 201481098, TA_UL_FU_OPP_HARMONY_ME_DIRECT, Test Company RD.05 - [SAP].mhtml")
URL url = html.toURI().toURL();
WebUI.openBrowser(url.toExternalForm());


WebUI.switchToFrame(makeTO("//iframe[@id='CRMApplicationFrame']"), 5)
WebUI.switchToFrame(makeTO("//frame[@id='WorkAreaFrame1']"), 5)

List<String> candidates = [
	"/html/body[@role='main']",
	"//form[@id='myFormId']",
	"//table[@id='th-l-workAreaMainTable']",
	"//table[@id='th-l-workAreaMainTable']//div[@id='thtmlbOverviewPageBox']",
	"//table[@id='th-l-workAreaMainTable']//div[@id='thtmlbOverviewPageBox']//*[local-name()='grid']",
	"//table[@id='th-l-workAreaMainTable']//div[@id='thtmlbOverviewPageBox']//*[contains(text(), 'ID:']"
	];
for (String locator in candidates) {
	TestObject to = makeTO(locator);
	WebUI.verifyElementPresent(to, 5, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.closeBrowser();


TestObject makeTO(String expr) {
	TestObject to = new TestObject(expr);
	to.addProperty("xpath", ConditionType.EQUALS, expr)
	return to
}