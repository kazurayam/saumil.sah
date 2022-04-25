import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


File html = new File("Unified Lead_ 201481098, TA_UL_FU_OPP_HARMONY_ME_DIRECT, Test Company RD.05 - [SAP].mhtml")
URL url = html.toURI().toURL();
WebUI.openBrowser(url.toExternalForm());

WebUI.switchToFrame(makeTO("//*[@id='CRMApplicationFrame']"), 5)

WebUI.switchToFrame(makeTO("//*[@id='WorkAreaFrame1']"), 5)

TestObject to = makeTO("//td/div/span/label[normalize-space(.) = 'ID:']/parent::span/parent::div/parent::td/following-sibling::td[1]//span")
String val = WebUI.getText(to)

println val

WebUI.closeBrowser();


TestObject makeTO(String expr) {
	TestObject to = new TestObject(expr);
	to.addProperty("xpath", ConditionType.EQUALS, expr)
	return to
}
