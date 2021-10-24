package com.ctm.appiumautomation.steps;

import com.ctm.appiumautomation.utils.PropertiesManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.ctm.appiumautomation.pages.*;
import com.ctm.appiumautomation.utils.CommonUtils;

public class OnboardingSteps {

    private final RemoteWebDriver driver = CommonUtils.getRemoteWebDriver();
    CookiePage cookiePage = new CookiePage(driver);
    OnboardingStartupPage onboardingStartupPage = new OnboardingStartupPage(driver);
    FindRewardsNearYouPage findRewardsNearYouPage = new FindRewardsNearYouPage(driver);
    GetHandyAlertsPage getHandyAlertsPage = new GetHandyAlertsPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    EnterSignInDetailsPage enterSignInDetailsPage = new EnterSignInDetailsPage(driver);
    PostSignInMemberPage postSignInMemberPage = new PostSignInMemberPage(driver);
    HomePage homePage = new HomePage(driver);
    ComparePage comparePage = new ComparePage(driver);
    PreviousQuotesPage previousQuotesPage = new PreviousQuotesPage(driver);
    RewardsPage rewardsPage = new RewardsPage(driver);
    MeerkatMealsWelcomeShowcasePage meerkatMealsWelcomeShowcasePage = new MeerkatMealsWelcomeShowcasePage(driver);
    MeerkatMealsHomePage meerkatMealsHomePage = new MeerkatMealsHomePage(driver);
    AreYouDiningOutOrCollectingPage areYouDiningOutOrCollectingPage = new AreYouDiningOutOrCollectingPage(driver);
    WhereAreYouDiningPage whereAreYouDiningPage = new WhereAreYouDiningPage(driver);
    HowManyOfYouAreDiningPage howManyOfYouAreDiningPage = new HowManyOfYouAreDiningPage(driver);

    @Given("I am a member and I sign in")
    public void iAmAMemberAndISignIn() {
        //cookiePage.goToShowcasePage().goToFindRewardsNearYou().goToGetHandyAlerts().goToSignInScreen().goToEnterSignInDetailsScreen();
        cookiePage.goToShowcasePage();
        onboardingStartupPage.goToFindRewardsNearYou();
        findRewardsNearYouPage.goToGetHandyAlerts();
        getHandyAlertsPage.goToSignInScreen();
        signInPage.goToEnterSignInDetailsScreen();
        enterSignInDetailsPage.goToPostSignInMemberPage();
    }

    @When("I get past the post sign in screen")
    public void iGetPastThePostSignInScreen() {
        postSignInMemberPage.goHomeScreen();
    }

    @Then("I should get to the home screen")
    public void iShouldGetToTheHomeScreen() {
        homePage.stayOnHomePage();
    }

    @When("I open the rewards tab and navigate to meals")
    public void iOpenTheRewardsTabAndNavigateToMeals() {
        postSignInMemberPage.goHomeScreen();
        homePage.goToRewardsPage();
        rewardsPage.goToMeerkatMealsWelcomeShowcasePage();
        meerkatMealsWelcomeShowcasePage.goToMeerkatMealsWelcomeShowcasePage();
        meerkatMealsHomePage.goToAreYouDiningOutOrCollectingPage();
        areYouDiningOutOrCollectingPage.goToWhereAreYouDiningPage();
        whereAreYouDiningPage.goToHowManyOfYouAreDiningPage();
        howManyOfYouAreDiningPage.goToMealsMembershipCardPage();
    }

    @Then("I should be able to access meals membership card")
    public void iShouldBeAbleToAccessMealsMembershipCard() {
    }

    @When("I open the comparison tab")
    public void iOpenTheComparisonTab() {
        postSignInMemberPage.goHomeScreen();
        homePage.goToComparePage();
    }

    @Then("I should be able to access my previous quotes")
    public void iShouldBeAbleToAccessMyPreviousQuotes() {
        comparePage.goToPreviousQuotesTab();
        previousQuotesPage.stayOnPreviousQuotesTab();
    }
}
