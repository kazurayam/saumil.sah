
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

File html = new File("Unified Lead_ 201481098, TA_UL_FU_OPP_HARMONY_ME_DIRECT, Test Company RD.05 - [SAP].mhtml")
URL url = html.toURI().toURL();
WebUI.openBrowser(url.toExternalForm());

WebDriver myDriver = DriverFactory.getWebDriver()

CRMApplicationFrame = myDriver.findElement(By.id("CRMApplicationFrame"))
myDriver.switchTo().frame(CRMApplicationFrame)

WorkAreaFrame1 = myDriver.findElement(By.id("WorkAreaFrame1"))
myDriver.switchTo().frame(WorkAreaFrame1)

WebElement el = myDriver.findElement(By.xpath("//td/div/span/label[normalize-space(.) = 'ID:']/parent::span/parent::div/parent::td/following-sibling::td[1]//span"))
String val = el.getText()

println val    // => 201481098

myDriver.quit()