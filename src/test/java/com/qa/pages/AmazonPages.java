/**
 * 
 */
package com.qa.pages;

/**
 * @author MandulaS
 *
 */

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	
	WebDriver Driver;
	
	@FindBy(name="url")
	WebElement CategoryList;
	
	
	public boolean getCategoryListDisplayed() {
		
		return CategoryList.isDisplayed();
	}
	
	
	public void SetCategoryList(String itemname) {
		
		Select SelectCategory = new Select(CategoryList);
		
		SelectCategory.selectByVisibleText(itemname);
	}
	
	
	public String getFirstSelectedOption() {
		
		Select SelectCategory = new Select(CategoryList);
		
		return SelectCategory.getFirstSelectedOption().getText();
	}
	
	
	@FindBy(id="twotabsearchtextbox")
	@CacheLookup
	WebElement SearchInput;
	
	
	public void setSearchInput(String Input) {
		SearchInput.clear();
		SearchInput.sendKeys(Input);
	}
	
	public boolean getSearchInputDisplayed() {
		return SearchInput.isDisplayed();
	}
	
	
	
	@FindBy(id="nav-search-submit-button")
	@CacheLookup
	WebElement MagnifierBtn;
	
	public void setMagnifierBtn() {
		MagnifierBtn.click();
	}
	
	
	
	@FindAll(@FindBy(tagName = "a"))
	@CacheLookup
	List<WebElement> AllLinks;
	
	public List<WebElement> getAllLinks() {
		
		return AllLinks;
	}
	
	
	
	
	@FindAll(@FindBy(xpath="/html/body/div[1]/div[5]/div[4]/ul/li"))
	@CacheLookup
	List<WebElement> Countries;
	
	
	public List<WebElement> getAllCountries() {
		
		return Countries;
	}
	
	
	
	@FindAll(@FindBy(className = "nav_a"))
	@CacheLookup
	List<WebElement> AllFooterLinks;
	
	public List<WebElement> getAllFooterLinks() {
		
		return AllFooterLinks;
	}
	
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	@CacheLookup
	List<WebElement> ItemNames;
	
	public List<WebElement> GetAllItemName() {
		return ItemNames;
	}
		
	
	public AmazonPages(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	
	

}

