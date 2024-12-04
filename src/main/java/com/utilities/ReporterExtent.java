package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class ReporterExtent {
    protected static ExtentSparkReporter sparkreporter;
    protected static ExtentReports extent;
    protected static ExtentTest test;


    @BeforeSuite
    public static void setup(){
        sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/extent.html");
        sparkreporter.config().setTheme(Theme.STANDARD);
        sparkreporter.config().setDocumentTitle("Demo Run Appium Session");
        sparkreporter.config().setReportName("Demo Runs for appium session");

        extent = new ExtentReports();
        extent.attachReporter(sparkreporter);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Session", "Appium session");
    }



    @AfterSuite
    public static void closereport(){
        if (extent != null) {
            extent.flush();
        }
    }
}
