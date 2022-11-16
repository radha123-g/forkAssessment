package com.ForkTechnology;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ForkTechnology.ObjectRepository.IMDBPage;
import com.ForkTechnology.ObjectRepository.WikiPediaPage;
import com.Utilities.BaseClass;
import com.Utilities.ExcelUtility;
import com.Utilities.FileUtilty;
import com.Utilities.WebDriverUtility;


public class PushpaReleaseDateAndCountry extends BaseClass{
 
	@Test
	public void pushpaReleasedataAndCountry() throws Throwable{
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtilty flib=new FileUtilty();
		String pushpa = eLib.getDataFromExcel("Sheet1", 0, 0);
		IMDBPage imdb=new IMDBPage(driver);
		imdb.getIMdbSearch().sendKeys(pushpa);
	    imdb.getSearchclickBtn().click();
	    imdb.getMovieName().click();
		wLib.scrollToAction(driver);
		
		String releaseDate = imdb.getReleaseDate().getText();
		System.out.println(releaseDate);
		String country = imdb.getCountry().getText();
		System.out.println(country);
		String url = flib.getPropertyValue("urlofWiKipedia");
		driver.navigate().to(url);
		String pushpa1 = eLib.getDataFromExcel("Sheet1", 0, 1);
		WikiPediaPage wiki=new WikiPediaPage(driver);
		wiki.getMovieName().sendKeys(pushpa1);
	    wiki.getSearchBtn().click();
	    String releasedate2=wiki.getReleaseDate().getText();
	    String country2=wiki.getCountry().getText();
		System.out.println(releasedate2);
		System.out.println(country2);
		SoftAssert softassert = new SoftAssert();
		 softassert.assertEquals(country, country2);
		 Reporter.log("country is pass",true);
		 
	    softassert.assertEquals(releaseDate,releasedate2);
	    softassert.assertAll();
	    
	   
		
		
	}
}
