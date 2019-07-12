package com.ui.web.maventest;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ui.web.util.ParseValue;

import jxl.Workbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoginPar {
	private WebDriver webdriver;
	String resource = "C:\\Users\\admin.DESKTOP-CV0PJ4O\\Desktop\\test.xls";
	@BeforeClass
	public void beforeClass() {
		File file = new File("D:\\jar\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		webdriver = new ChromeDriver();
	}
	@Test
	public void loginBoss() {
		ExcelWorkBook excelWorkBook = new ExcelWorkBook();
		webdriver.get("https://pay.xunlei.com/index.html"); 
		
		webdriver.manage().window().maximize();
		List<String> userList = excelWorkBook.readUsername(resource);
		List<String> passList = excelWorkBook.readPassword(resource);

		webdriver.switchTo().frame("loginIframe");
        WebElement user = webdriver.findElement(By.id("al_u"));	  
        WebElement pass = webdriver.findElement(By.id("al_p"));
        String username = userList.get(0);
        String password = passList.get(0);
        user.sendKeys(username);
        pass.sendKeys(password);
        
        WebElement submit = webdriver.findElement(By.id("al_submit"));
        submit.click();
	}
	@Test(dependsOnMethods="loginBoss")
	public void getValue() {
		DataHandle handle = new DataHandle();
		String urlStr = "https://advertpay-vip-ssl.xunlei.com/web/paymentinfo?callback=jQuery11240031467037552653565_1562723460254&userid=160223206&sessionid=ws001.035DF5841C63533A3E6C576868C020A6&payconfid=&_=1562723460257";

		handle.sendGet(urlStr);

	}

	
}
