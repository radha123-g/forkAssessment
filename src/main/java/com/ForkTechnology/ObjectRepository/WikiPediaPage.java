package com.ForkTechnology.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPediaPage {
	//initialization
			public WikiPediaPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			@FindBy(xpath="//input[@name='search']")
			private WebElement MovieName;
			
			@FindBy(xpath = "//input[@class='searchButton']")
			private WebElement searchBtn;
			
			@FindBy(xpath = "//div[text()='Release date' ]/parent::th/following-sibling::td//li")
			private WebElement releaseDate;
			
			@FindBy(xpath="//th[text()='Country']/following-sibling::td[@class='infobox-data']")
			private WebElement country;

			public WebElement getMovieName() {
				return MovieName;
			}

			public WebElement getSearchBtn() {
				return searchBtn;
			}

			public WebElement getReleaseDate() {
				return releaseDate;
			}

			public WebElement getCountry() {
				return country;
			}

			
}
