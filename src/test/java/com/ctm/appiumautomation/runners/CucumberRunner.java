package com.ctm.appiumautomation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue =  {"com.ctm.appiumautomation.steps"},
        plugin = {"pretty", "html:reports/cucumber/pretty/", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        monochrome = true,
        tags = {"@smoke"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void cleanAllure() throws IOException {
        Runtime rt = Runtime.getRuntime();
        String[] commands = {"rm", "-rf", "reports/cucumber/allure-results/"};
        rt.exec(commands);
    }

    @AfterSuite
    public void generateAllure() throws IOException {
        Runtime rt = Runtime.getRuntime();
        String[] commands = {"allure", "generate", "reports/cucumber/allure-results", "-o", "reports/cucumber/allure-results/allure-report", "-c"};
        rt.exec(commands);
    }
}
