package com.cucumber.testruner;

import org.junit.runner.RunWith;
import com.cucumber.resources.MainResources;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = MainResources.feature)
public class RunCucumberMain
{

}
