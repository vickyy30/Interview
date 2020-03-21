package demo;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		boolean flag = false;
		
		while(!flag) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter country name: ");
		String line = scan.next();
		if(line.equals("end")) {
			flag = true;
			break;
		}
		String xpath = "//*[@id='example']//tbody//td[text()='country']//following-sibling::td";
		String text = driver.findElement(By.xpath(xpath.replaceAll("country", line))).getText();
		System.out.println("Rank is: "+text);
		}
		
		System.out.println("Program Ended");
	
	}

}
