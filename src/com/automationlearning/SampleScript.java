/**
 * 
 */
package com.automationlearning;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author CHIRAG
 *
 */
public class SampleScript {

	AppiumDriver<MobileElement> driver;
	String path;
	
	
	public void setup()
	{
		System.out.println("Session is creating");
		path = System.getProperty("user.dir");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Moto G");
		cap.setCapability("app", path+"/ApiDemos.apk");
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
	}
	
	public void validateText()
	{
		driver.findElementByAccessibilityId("Accessibility").click();
		String text = driver.findElementByAccessibilityId("Accessibility Node Provider").getText();
		if(text.equalsIgnoreCase("Accessibility Node Provider"))
		{
			System.out.println("Passed");
		} else
		{
			System.out.println("Failed");
		}
	}
	
	public void tearDown()
	{
		driver.quit();
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		HashMap<String, String> hmap = new HashMap<String, String>();
		String str="";
		BufferedReader br = new BufferedReader(new FileReader(new File("<path to my csv file>.csv")));
		//Scanner scanner = new Scanner(new FileReader("/home/safia/drebinDataset/apkWithInternet/withPkgName/drebin0.csv"));
		while((str = br.readLine())!=null) {
			
			String[] st=str.split(",");
			//String k=st[2];
			//#String v=st[3];
			//System.out.println(st.length); 
			//#System.out.println(v); 
			hmap.put(st[2],st[3]);
			/*for (String name: hmap.keySet()){

	            String key =name.toString();
	            String value = hmap.get(name).toString();  
	            System.out.println(key + " " + value);  


	} */
		}
	    System.out.println(hmap);  
		for (String name: hmap.keySet()){

            String key =name.toString();
            String value = hmap.get(name).toString(); 
           if(key.equals("sample117.apk")) {
        	   System.out.println(value);
           }
            
        


} 
		SampleScript obj = new SampleScript();
		obj.setup();
		obj.validateText();
		TimeUnit.SECONDS.sleep(20);
		obj.tearDown();

	}
}