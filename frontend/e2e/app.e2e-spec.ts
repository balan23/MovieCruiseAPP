import { AppPage } from './app.po';
import { browser, by, element, protractor } from 'protractor';
import { async } from '@angular/core/testing';

describe('movie-cruiser-application', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('display title', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('Movie Cruiser Application');
  });
  it(' redirect to login page', () => {
    expect(browser.getCurrentUrl()).toContain('/login');
  });

  it('redirect to register page', () => {
    browser.element(by.id('register')).click();
    expect(browser.getCurrentUrl()).toContain('/register');
  });
  it('register user and redirect to login', () => {
    browser.element(by.id('firstName')).sendKeys('manobalan');
    browser.driver.sleep(1000);
    browser.element(by.id('lastName')).sendKeys('mayonguru');
    browser.driver.sleep(1000);
    browser.element(by.id('userId')).sendKeys('balan2020');
    browser.driver.sleep(1000);
    browser.element(by.id('password')).sendKeys('thedon12');
    browser.driver.sleep(500);
    browser.element(by.id('register')).submit();
    expect(browser.getCurrentUrl()).toContain('/login');
  });

  it('login user redirect to popular movies after login', () => {
    browser.element(by.id('userId')).sendKeys('balan2020');
    browser.element(by.id('password')).sendKeys('thedon12');
    browser.element(by.buttonText('Login')).submit();
    expect(browser.getCurrentUrl()).toContain('/movies/popular');
  });
  it(' redirect to toprated  page', () => {
    browser.element(by.id('top_rated')).click();
    expect(browser.getCurrentUrl()).toContain('/movies/top_rated');
  });
  it('redirect to watchlist page', () => {
    browser.element(by.id('watchlist')).click();
    expect(browser.getCurrentUrl()).toContain('/movies/watchlist');
  });
  it('redirect to popular movie page', () => {
    browser.element(by.id('popular')).click();
    expect(browser.getCurrentUrl()).toContain('/movies/popular');
  });
  it('should redirect to search movie page', () => {
    browser.element(by.id('search')).click();
    expect(browser.getCurrentUrl()).toContain('/movies/search');
  });

  it('should able to search a word King', () => {
    browser.element(by.id('search')).click();
    expect(browser.getCurrentUrl()).toContain('/movies/search');
    browser.element(by.id('searchBox')).sendKeys('King');
    browser.element(by.id('searchBox')).sendKeys(protractor.Key.ENTER);
    browser.driver.sleep(2000);
    const searchMovieElem = element.all(by.css('.movie-title'));
    // expect(searchMovieElem.count()).toBe(20);
    // for (let i=0;i<=1;i+=1){
    //   expect(searchMovieElem.get(i).getText()).toContain("King");
    // }
  });
  
  it('should able to add movie to watchlist from search', async () => {
    browser.driver.manage().window().maximize();
    browser.driver.sleep(2000);
    const searchMovieItems = element.all(by.css('.movie-thumbnail'));
    expect(searchMovieItems.count()).toBe(20);
    searchMovieItems.get(0).click();
    browser.element(by.css('.watchlist')).click();
  });

  it('should able to see added movie in the watchlist',() => {
    browser.element(by.id('watchlist')).click();
    expect(browser.getCurrentUrl()).toContain('/movies/watchlist');
    const searchMovieItems = element.all(by.css('.movie-thumbnail'));
    expect(searchMovieItems.count()).toBe(1);
  });

  it('should update the comments successfully',async () => {
    //browser.element(by.id('wishlist')).click();
    expect(browser.getCurrentUrl()).toContain('/movies/watchlist');
    const searchMovieItems = element.all(by.css('.movie-thumbnail'));
    //expect(searchMovieItems.count()).toBe(1);
    //searchMovieItems.get(0).click();
    browser.element(by.css('.update')).click();
    browser.element(by.id('comments')).clear();
    browser.element(by.id('comments')).sendKeys("Update testing");
    browser.element(by.id('updateComment')).click();
    browser.element(by.id('top_rated')).click();
    browser.element(by.id('watchlist')).click();
    const searchMovieUpdate = element.all(by.css('.movie-thumbnail'));
    const update = searchMovieUpdate.get(0).element(by.css('.movie-overview')).getText();
    expect(update).toContain("Update testing");
  });

  it('should delete successfully on delete from the watchlist ',() => {
    browser.element(by.id('watchlist')).click();
    expect(browser.getCurrentUrl()).toContain('/movies/watchlist');
    browser.element(by.css('.delete')).click();
    const searchMovieItems = element.all(by.css('.movie-thumbnail'));
    expect(searchMovieItems.count()).toBe(0);
  });

  it('should logout and lands in login page', () => {
    browser.element(by.id('logout')).click();
    expect(browser.getCurrentUrl()).toContain('/login');
  });

  it('Restricted access to toprated  page after logout', () => {
    browser.element(by.id('top_rated')).click();
    expect(browser.getCurrentUrl()).toContain('/login');
  });
  it('Restricted access to wishlist page after logout', () => {
    browser.element(by.id('watchlist')).click();
    expect(browser.getCurrentUrl()).toContain('/login');
  });
  it('Restricted access to popular movie page after logout', () => {
    browser.element(by.id('popular')).click();
    expect(browser.getCurrentUrl()).toContain('/login');
  });
  it('Restricted access to search movie page after logout', () => {
    browser.element(by.id('search')).click();
    expect(browser.getCurrentUrl()).toContain('/login');
  });
});
