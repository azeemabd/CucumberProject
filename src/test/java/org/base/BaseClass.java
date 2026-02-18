package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BaseClass {
public static WebDriver driver;
public static Actions a;
public static Alert al;
public static Select s;
public static Robot r;
public static WebDriverWait w;
public static JavascriptExecutor js;
public static void launchBrowser() {
driver=new ChromeDriver();
driver.manage().window().maximize();
}

public static void loadUrl(String urlload) {
driver.get(urlload);
}

public static void titleFetch() {
String t=driver.getTitle();
System.out.println(t);
}
public static void urlFetch() {
String t1=driver.getCurrentUrl();
System.out.println(t1);
}
public static void textFill(WebElement ele,String text) {
ele.sendKeys(text);
}



public static void buttonClick(WebElement ele) {
ele.click();
}
public static void attributeData(WebElement ele) {
String a1=ele.getAttribute("value");
System.out.println(a1);
}
public static void Textdata(WebElement ele) {
String t2=ele.getText();
System.out.println(t2);
}
public static void parentWindow() {
String s=driver.getWindowHandle();
System.out.println(s);
}
public static void childwindow() {
Set<String> s1=driver.getWindowHandles();
System.out.println(s1);
}
public static void switchToWindowByIndex(int index) {
Set<String> s=driver.getWindowHandles();
List<String> li=new ArrayList();
li.addAll(s);
driver.switchTo().window(li.get(index));
}
public static void closewindow() {
driver.close();
}
public static void quitwindow() {
driver.quit();
}
public static void buttonenable(WebElement ele) {
boolean b1=ele.isEnabled();
System.out.println(b1);
}
public static void buttondisplay(WebElement ele) {
boolean b2=ele.isDisplayed();
System.out.println(b2);
}
public static void buttonselect(WebElement ele) {
boolean b3=ele.isSelected();
System.out.println(b3);
}
public static void buttonClear(WebElement ele) {
ele.clear();;
}
public static void actionMovetoele(WebElement ele) {
a=new Actions(driver);
a.moveToElement(ele).perform();
}
public static void actionDoubleClick(WebElement ele) {
a=new Actions(driver);
a.doubleClick(ele).perform();
}
public static void actionContextClick(WebElement ele) {
a=new Actions(driver);
a.contextClick(ele).perform();
}
public static void actiondraganddrop(WebElement src,WebElement des) {
a=new Actions(driver);
a.dragAndDrop(src, des).perform();
}
public static void acceptAlert() {
al=driver.switchTo().alert();
al.accept();
}
public static void dimissalert() {
al=driver.switchTo().alert();
al.dismiss();
}
public static void visibleSelect(WebElement ele,String text) {
s=new Select(ele);
s.selectByVisibleText(text);
}
public static void valueSelect(WebElement ele,String value) {
s=new Select(ele);
s.selectByValue(value);
}
public static void indexselect(WebElement ele,int index) {
s=new Select(ele);
s.selectByIndex(index);
}
public static void visibleDeselect(WebElement ele,String text) {
s=new Select(ele);
s.deselectByVisibleText(text);
}
public static void valuedeSelect(WebElement ele,String value) {
s=new Select(ele);
s.deselectByValue(value);
}
public static void indexdeselect(WebElement ele,int index) {
s=new Select(ele);
s.deselectByIndex(index);
}
public static void alldeselect(WebElement ele) {
s=new Select(ele);
s.deselectAll();
}
public static void checkMultiple(WebElement ele) {
s=new Select(ele);
boolean b=s.isMultiple();
System.out.println(b);
}


public static void fullOption(WebElement ele) {
s=new Select(ele);
List<WebElement> option=s.getOptions();
for(WebElement x:option) {
String s=x.getText();
System.out.println(s);
}}


public static void firstopt(WebElement ele) {
s=new Select(ele);
WebElement t=s.getFirstSelectedOption();
String s=t.getText();
System.out.println(s);
}

public static void allOption(WebElement ele) {
s=new Select(ele);
List<WebElement> option=s.getAllSelectedOptions();
for(WebElement x:option) {
String s=x.getText();
System.out.println(s);
}}
public static void robotKeys() throws AWTException {
r=new Robot();
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
}

public static void switchToFrame(int index) {
    driver.switchTo().frame(index);
}


public static void switchToFrame(String nameOrId) {
    driver.switchTo().frame(nameOrId);
}


public static void switchToFrame(WebElement frameEle) {
    driver.switchTo().frame(frameEle);
}



public static void switchToParentFrame() {
    driver.switchTo().parentFrame();
}


public void switchToDefaultContent() {
    driver.switchTo().defaultContent();
}

//implicit wait
public static void implicitWait(int seconds) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
}


//webdriver wait
//visibilityOf
public static void webDriverWaitvisibilityOf(WebElement ele) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.visibilityOf(ele));
}
//visibilityOfAllElements
public static void webDriverWaitvisibilityOfAllElements(List<WebElement> ele) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.visibilityOfAllElements(ele));
}
//visibilityOfAllElementsLocated
public static void webDriverWaitvisibilityOfAllElementsLocated(By locator) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
//visibilityOfAllElementsLocatedBy
public static void webDriverWaitvisibilityOfAllElementsLocatedBy(By locator) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}
//invisibilityOfTheElementLocated
public static void webDriverWaitinvisibilityOfTheElementLocated(By locator) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.invisibilityOfElementLocated(locator));
}
//invisibilityOfElementLocatedWithText
public static void webDriverWaitinvisibilityOfElementLocatedWithText(WebElement locator,String value) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.invisibilityOfElementWithText((By) locator, value));
}
//textToBePresentInElement
public static void webDriverWaitTextToBePresentInElement(WebElement ele,String value) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.textToBePresentInElement(ele, value));
}
//textToBePresentInElementLoacted
public static void webDriverWaitTextToBePresentInElementLoacted(By locator,String text) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
}

//textToBePresentInElementValue
public static void webDriverWaitTextToBePresentInElementValue(By locator,String text) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
}
//presenceOfElementLoacted
public static void webDriverWaitPresenceOfElementLoacted(By locator) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.presenceOfElementLocated(locator));
}
//presenceOfElementLoactedBy
public static void webDriverWaitPresenceOfElementLoactedBy(By locator) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
}
//elementSelectionStateToBe
public static void webDriverWaitElementSelectionStateToBe(By locator,boolean selected) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));
}
//elementToBeClickable
public static void webDriverWaitElementToBeClickable(WebElement ele) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.elementToBeClickable(ele));
}
//elementToBeSelected
public static void webDriverWaitElementToBeSelected(WebElement ele) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.elementToBeSelected(ele));
}

//frameToBeAvailableAndSwitchToIt
public static void webDriverWaitFrameToBeAvailableAndSwitchToIt(By locator) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
}
//titleIs
public static void webDriverWaitTitleIs(String title) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.titleIs(title));
}
//titleContains
public static void webDriverWaitTitleContains(String title) {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.titleContains(title));
}

//alertIsPresent
public static void webDriverWaitAlertIsPresent() {
w = new WebDriverWait(driver , Duration.ofSeconds(5));
w.until(ExpectedConditions.alertIsPresent());
al = driver.switchTo().alert();
al.accept();
}

public static void getsnap(String filename) throws IOException {
TakesScreenshot tk=(TakesScreenshot)driver;
File src=tk.getScreenshotAs(OutputType.FILE);
File des=new File("C:\\Users\\sohai\\eclipse-workspace\\MavenProject\\Screenshot\\"+filename+".png");
FileUtils.copyFile(src, des);


}
public static void jsSendKeys(WebElement ele,String Value) {
js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].setAttribute('value','"+Value+"')", ele);
}
public static void jsClick(WebElement ele) {
js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click()", ele);
}
public static void jsScrollDown(WebElement ele) {
js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].ScrollIntoView(true)", ele);
}
public static void jsScrollUp(WebElement ele) {
js=(JavascriptExecutor)driver;
Object o=js.executeScript("arguments[0].ScrollIntoView(false)", ele);
return;
}
public static void jsgetattribute(WebElement ele) {
js=(JavascriptExecutor)driver;
js.executeScript("return arguments[0].getAttribute('Value')", ele);
}

public static String readFromExcel(String sheet,int row,int column) throws IOException {
//File f=new File("C:\\Users\\sohai\\eclipse-workspace\\MavenProject\\XlFloder\\sheet.xlsx");
	File f = new File("/Users/azeee/eclipse-workspace/AdactinHotelAppProject/XLFolder/Spreadsheet 1.xlsx");
FileInputStream fis=new FileInputStream(f);
Workbook w=new XSSFWorkbook(fis);
Sheet sh=w.getSheet("Sheet1");
//for(int i=0;i<sh.getPhysicalNumberOfRows();i++) {
Row r=sh.getRow(row);
//for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
Cell c = r.getCell(column);


int type = c.getCellType();
String value = "";

if (type == 1) {
    // String cell
    value = c.getStringCellValue();
}
else if (DateUtil.isCellDateFormatted(c)) {
    // Date cell
    Date dd = c.getDateCellValue();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    value = sdf.format(dd);
}
else {
    // Numeric cell
    double num = c.getNumericCellValue();
    long l = (long) num;
    value = String.valueOf(l);
}

System.out.println(value);
return value;

}








}
