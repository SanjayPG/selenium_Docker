package com.search.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchmodule.pages.SearchPage;
import com.test.baseTest.BaseTest;

public class SearchTest extends BaseTest {
		
	@Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.loadUrl();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();
         System.out.println(size);
        Assert.assertTrue(size > 0);
    }

	
	
	
	

}
