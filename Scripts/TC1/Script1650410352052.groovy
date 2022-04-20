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
	"//table[@id='th-l-workAreaMainTable']//div[@id='thtmlbOverviewPageBox']//thtmlb:grid",
	"//table[@id='th-l-workAreaMainTable']//grid[1]/gridcell[1]",
	"//table[@id='th-l-workAreaMainTable']//tr[contains(text(),'General Data')]"
	];	
for (String locator in candidates) {	
	TestObject to_leadId = makeTO(locator);
	WebUI.verifyElementPresent(to_leadId, 5)
}

WebUI.closeBrowser();


TestObject makeTO(String expr) {
	TestObject to = new TestObject(expr);
	to.addProperty("xpath", ConditionType.EQUALS, expr)
	return to
}