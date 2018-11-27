package com.hieu.work1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver = null;
	public String URL_BASE = "http://todomvc.com/examples/react/#/";
 
  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
		// setup driver
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
  }
  
  @Test(priority = 1)
  public void Test1() {
	  //kiểm tra app có xuất hiện trong vòng 1s
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  
	  //mở app todo
	  driver.get(URL_BASE);
	  
	  //tìm todoapp
	  WebElement sectionToDoApp = driver.findElement(By.className("todoapp"));
	  
  }
  
  @Test(priority = 2)
  public void Test2() {
	  //kiểm tra input có xuất hiện trong vòng 1s
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  
	  //mở app todo
	  driver.get(URL_BASE);
	  
	  //tìm input
	  WebElement txtinput = driver.findElement(By.className("new-todo"));
	  
	  //kiểm tra giá trị ô input là rỗng
	  Assert.assertEquals(txtinput.getText(), "");
	  
  }
  
  @Test(priority = 3)
  public void Test3() {
	  //mở app todo
	  driver.get(URL_BASE);
	  
	  //kiểm tra todo-list không xuất hiện trong 5s
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("todo-list")));
	  
	  
  }
  
  @Test(priority = 4)
  public void Test4() {
	  //chờ 1s
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  
	  //mở app todo
	  driver.get(URL_BASE);
	  
	  //tìm input
	  WebElement txtinput = driver.findElement(By.className("new-todo"));
	  
	  //nhập key và nhấn enter
	  txtinput.sendKeys("Todo Item 1",Keys.ENTER);
	  
	  //tìm todo-list
	  WebElement txtItem = driver.findElement(By.className("todo-list"));
	  
	  //kiểm tra giá trị trong todo-list có đúng như mình nhập
	  Assert.assertEquals(txtItem.getText(), "Todo Item 1");
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
		//đóng browser
		driver.quit();
  }

}
