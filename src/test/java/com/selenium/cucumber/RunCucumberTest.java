package com.selenium.cucumber;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/java/com/selenium/cucumber/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.selenium.cucumber")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@SmokeTest")
@ConfigurationParameter(key = Constants.PARALLEL_CONFIG_STRATEGY_PROPERTY_NAME, value = "dynamic")
@ConfigurationParameter(key = Constants.PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, "
		+ "html:target/cucumber-reports/Cucumber.html, "
		+ "json:target/cucumber-reports/Cucumber.json, "
		+ "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm, "
		+ "junit:target/cucumber-reports/Cucumber.xml")
public class RunCucumberTest { 
}