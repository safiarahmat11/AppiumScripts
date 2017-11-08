
package com.automationlearning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;

public class textTpacketcapture {

	AppiumDriver<MobileElement> driver;
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Nexus 9");
		cap.setCapability("appPackage", "jp.co.taosoftware.android.packetcapture");
		cap.setCapability("appActivity", "jp.co.taosoftware.android.packetcapture.PacketCaptureActivity");
		cap.setCapability("noReset",true);
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void addTwoNumber(HashMap<String,String> hmap)
	{
		List<String> l = new ArrayList<String>(hmap.keySet());
	
		driver.findElementById("jp.co.taosoftware.android.packetcapture:id/captureToggleButton").click();
		driver.findElementById("android:id/button1").click();
		((AndroidDriver<MobileElement>) driver).openNotifications();
		/*driver.findElementByAccessibilityId("plus").click();
		driver.findElementByXPath("//*[@text='2']").click();
		driver.findElementByXPath("//android.widget.GridLayout[@resource-id='com.android.calculator2:id/pad_numeric']//android.widget.Button[@index='11']").click();
		String text = driver.findElementById("com.android.calculator2:id/result").getText();
		if(text.equals("9"))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed"); 
		}*/
	}
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
	/**
	 * @param args
	 * @author CHIRAG
	 * @throws MalformedURLException 
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws MalformedURLException,IOException, InterruptedException {
		HashMap<String, String> hmap = new HashMap<String, String>();
		String str="";
		BufferedReader br = new BufferedReader(new FileReader(new File("/home/safia/drebinDataset/apkWithInternet/withPkgName/drebin0.csv")));
		
		while((str = br.readLine())!=null) {
			
			String[] st=str.split(",");
			//String k=st[2];
			//#String v=st[3];
			//System.out.println(st.length); 
			//#System.out.println(v); 
			hmap.put(st[2],st[3]);
		}
	    System.out.println(hmap); 
	    /*
	     * 	for (String name: hmap.keySet()){

	            String key =name.toString();
	            String value = hmap.get(name).toString();  
	            System.out.println(key + " " + value);  


	} 
	     */
		
		textTpacketcapture obj = new textTpacketcapture();
		obj.setUp();
		obj.addTwoNumber(hmap);
		TimeUnit.SECONDS.sleep(20);
		obj.tearDown();
		/*new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                // your code here
		            }
		        }, 
		        5000 
		);*/

}
}