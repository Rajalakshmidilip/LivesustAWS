package com.livesust.configuration;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CucumberReport {
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest feature;
	public static ExtentTest scenario, step;
	public static String testDetail;

	public static void initializeExtentReport()
	{
		File OutputFolder = new File("./test-output");
		if (!OutputFolder.exists()) {
			if (OutputFolder.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create Directory");
			}
		} else {
			System.out.println("Directory already exists");
		}

		extent = new ExtentReports();
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "test-output/OneselfMobileIOSReport.html");
		extent = new ExtentReports();
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("DeelchatReport");
		reporter.config().setReportName("DeelChat Admin Web");
		extent.attachReporter(reporter);
	}	

	public static void reportCooldown() {
		extent.flush();
	}

	public void reportCreateFeature(String title) {
		feature = extent.createTest(Feature.class, title);
	}

	public void reportFeatureLog(String info) {
		feature.log(Status.INFO, info);
	}

	public void reportFeatureLogPass(String info) {
		feature.log(Status.PASS, info);
	}

	public void reportFeatureLogFatal(String Info) {
		feature.log(Status.WARNING, Info);
	}

	public void reportCreateScenario(String Scenario) {
		scenario = feature.createNode(Scenario.class, Scenario);
	}

	public void reportScenarioPass(String Details, String s) {
		scenario.pass(Details, MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());
	}

	public void reportScenarioPass(String Details) {
		scenario.pass(Details);
	}

	public void reportScenarioFail(String Details) {
		scenario.fail(Details);
	}

	public void reportScenarioFail(String Details, String s) {
		scenario.fail(Details, MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());
	}

	public void reportScenarioExpection(Exception e) {
		scenario.fail(e);
	}

	public static void createStep(String keyword, String stepName) throws ClassNotFoundException {
		switch (keyword) {
		case "Given":
			step = scenario.createNode(new GherkinKeyword("Given"), stepName);
			break;
		case "And":
			step = scenario.createNode(new GherkinKeyword("And"), stepName);
			break;
		case "When":
			step = scenario.createNode(new GherkinKeyword("When"), stepName);
			break;
		case "Then":
			step = scenario.createNode(new GherkinKeyword("Then"), stepName);
			break;
		default:
			step = scenario.createNode(new GherkinKeyword("And"), stepName);
		}
	}

	public void reportStepPass(String Details, String s) {
		step.pass(Details, MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());
	}

	public void reportStepPass(String Details) {
		step.pass(Details);
	}

	public void reportStepFail(String Details) {
		step.fail(Details);
	}

	public void reportStepFail(String Details, String s) {
		step.fail(Details, MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());
	}

	public void reportStepExpection(Exception e) {
		step.fail(e);
	}


}


