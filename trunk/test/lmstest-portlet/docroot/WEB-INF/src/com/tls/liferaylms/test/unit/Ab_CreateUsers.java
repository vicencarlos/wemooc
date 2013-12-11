package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.GetPage;
import com.tls.liferaylms.test.util.Login;
import com.tls.liferaylms.test.util.Sleep;

public class Ab_CreateUsers extends SeleniumTestCase {
	
	@Test
	public void testCreatePage() throws Exception {
		if(getLog().isInfoEnabled())getLog().info("init");
		try{
			Login login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());
			boolean loged = login.isLogin();
			assertTrue("Error not logued",loged);
			if (loged) {
				GetPage.getPage(driver, Context.getBaseUrl(), "/group/control_panel");
				
				WebElement users = getElement(By.id("_160_portlet_125"));
				assertNotNull("Not Menu users", users);
				users.click();

				Sleep.sleep(2000);
				WebElement usersText = getElement(By.id("_125_keywords"));
				assertNotNull("Not usersText", usersText);
				
				usersText.sendKeys(Context.getStudentUser());
				usersText.sendKeys(Keys.RETURN);
				
				Sleep.sleep(2000);

				if(getLog().isInfoEnabled())getLog().info("Check users...");
				WebElement search = getElement(By.id("usersAdminUsersPanel"));
				assertNotNull("Not search results", search);
				
				List<WebElement> tres = getElements(search, By.tagName("tr"));
				
				if(tres.size()<3){
					if(getLog().isInfoEnabled())getLog().info("Creating user...");
					createUser(Context.getStudentUser(), Context.getStudentName(), Context.getStudentPass());
				}
				
				GetPage.getPage(driver, Context.getBaseUrl(), "/group/control_panel");
				
				users = getElement(By.id("_160_portlet_125"));
				assertNotNull("Not Menu users", users);
				users.click();

				Sleep.sleep(2000);
				usersText = getElement(By.id("_125_keywords"));
				assertNotNull("Not usersText", usersText);
				
				usersText.sendKeys(Context.getTeacherUser());
				usersText.sendKeys(Keys.RETURN);
				
				Sleep.sleep(2000);

				if(getLog().isInfoEnabled())getLog().info("Check users...");
				search = getElement(By.id("usersAdminUsersPanel"));
				assertNotNull("Not search results", search);
				
				
				WebElement info = getElement(search, By.className("portlet-msg-info"));
				
				//tres = getElements(search, By.tagName("tr"));
				//if(getLog().isInfoEnabled())getLog().info("tres::"+tres.size());
				
				if(info!=null){
					if(getLog().isInfoEnabled())getLog().info("Creating user...");
					createUser(Context.getTeacherUser(), Context.getTeacherName(), Context.getTeacherPass());
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void createUser(String email,String name,String pass){
		WebElement addUsersA =  getElement(By.id("_125_kldx_menu_user"));
		assertNotNull("Not menu add user", addUsersA);
		  
		String location = addUsersA.getAttribute("href");
		
		GetPage.getPage(driver, "", location);
		
		WebElement sn = getElement(By.id("_125_screenName"));
		assertNotNull("Not sn for add user", sn);
		String[] names = email.split("@");
		if(names.length>0){
			sn.sendKeys(names[0]);
		}
		WebElement ea = getElement(By.id("_125_emailAddress"));
		assertNotNull("Not emailAddress for add user", ea);
		ea.sendKeys(email);
		
		WebElement ln = getElement(By.id("_125_lastName"));
		assertNotNull("Not lastName for add user", ln);
		ln.sendKeys(name);

		WebElement fn = getElement(By.id("_125_firstName"));
		assertNotNull("Not lastName for add user", fn);
		fn.sendKeys(name);
		
		WebElement input = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not input for add user", input);
		input.click();
		
		Sleep.sleep(4000);

		WebElement pl = getElement(By.id("_125_passwordLink"));
		assertNotNull("Not passwordLink for add user", pl);
		pl.click();

		WebElement p1 = getElement(By.id("_125_password1"));
		assertNotNull("Not passwordText for add user", p1);
		p1.sendKeys(pass);
		
		WebElement p2 = getElement(By.id("_125_password2"));
		assertNotNull("Not passwordText for add user", p2);
		p2.sendKeys(pass);
		
		input = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not input for add user", input);
		input.click();
	}
}
