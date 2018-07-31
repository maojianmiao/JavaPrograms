package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parallel {
  WebDriver driver;

  
  @BeforeTest
  @Parameters("num")
  public void setUp(int num) {
	  if (num == 1) {
		  driver = new FirefoxDriver();
	  }
	  if (num == 2) {
		  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  
  }
	
  @Test
  public void f1() {
	  driver.get("http://www.baidu.com");
  }

  @Test
  public void f2() {
	  System.out.println(this.hashCode()+ Thread.currentThread().getName());
  }
}
