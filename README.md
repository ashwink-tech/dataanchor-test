# Data-Anchor-Automation

<p align="center">
<b>A set of Behavioural tests that can be run against our UI.</b>
</p>

## Introduction
We are making use of [Cucumber](https://cucumber.io/) to write our UI Tests in Plain English. We will be testing and validating UI using [Selenium Webdriver](https://www.seleniumhq.org/projects/webdriver/). Selenium Webdriver helps to drive a browser natively as a user would either locally or on a remote machine using the Selenium Server it marks a leap forward in terms of browser automation.

## Feature Files
A Feature File is an entry point to the Cucumber tests. This is a file where you will describe your tests in Descriptive language (Like English). It is an essential part of Cucumber, as it serves as an automation test script. A feature file can contain a scenario or can contain many scenarios in a single feature file but it usually contains a list of scenarios. Feature files of our project will be present in features folder.

## Examples of Writing Test in Feature File

```gherkin
Feature: Verify the scenarios mentioned for the assignment

  @dataanchor
  Scenario: Verify user is able to login successfully
    When The user with email "settlers-cabin@iraatljd.mailosaur.net" is logging into the app
    Then Verify "Shared Page Name":"Text" "QA Assignment" is present on Shared Page

 ```

In above example, the keyword **Feature** stands for the Feature that we are testing, in this case To Test the Search Address Functionality for One Map.

@dataanchor is a **tag** which we will use in Hook class to set the browser  ( Nothing much to worry about it )

**Scenario** Each test is called a Scenario and is described using the Scenario: keyword.

**When** keyword defines the test action that will be executed.

**Then** is the keyword using which we will use to verify the expected result of the scenario.

We are passing the **data table** with headers Detail and Text. DataTables are also used to handle large amounts of data.

There are other gherkin [keywords](https://cucumber.io/docs/gherkin/reference/#keywords) as well. 

## Prerequisites
  * Java 8 and Above
  * Maven

## Running tests

 * To run the tests locally following are the steps:
   * Clone the repository : `git@github.com:ashwink-tech/dataanchor-test.git`
   * Traverse to the Repo folder and run following commands:
   * `cd /resources/runnerscript`
   * `sh local_test_runner.sh https://fenixshare.anchormydata.com/fenixpyre/s/669ff2910e5caf9f73cd28ea/QA%2520Assignment Chrome`
 
 * To run the specific scenario locally, run the following command (example):
   * `sh local_test_runner.sh https://fenixshare.anchormydata.com/fenixpyre/s/669ff2910e5caf9f73cd28ea/QA%2520Assignment Chrome features/dataanchor/DataAnchor.feature:4`
  here 4 is the line number of Scenario.
    
## Test Report

* Once the script is finished, we can find the report at `/target/cucumber-report-html/cucumber-html-reports/overview-features.html`
 
## Test Logs
* Logs will be displayed on Console as well as inside Logs folder.

## Screenshots
* Screenshots for failed scenarios will be present inside the Screenshots folder.

## Test Cases
* [Test Case Document Link](https://docs.google.com/spreadsheets/d/1EZzaPP0n7F3Ss7vn8R-di0Ne78hWvywfpzbU3hRr80U/edit?usp=sharing)


## More Details
* [Why BDD and Cucumber](https://ashwink-tech.notion.site/Why-BDD-and-Cucumber-b63aa7a9b692473bae3e5c8759f97755?pvs=4)
* [Libraries used for UI-Automation Framework](https://ashwink-tech.notion.site/Libraries-Used-24537d5c9206467fa653bc49726534bc?pvs=4)
* [UI-Automation Framework Architecture](https://ashwink-tech.notion.site/Framework-Architecture-0b0bdd96ec454e6f9d277e584ea8e89b?pvs=4)

 <img src="https://media.giphy.com/media/xT1R9Q12FdPq0Bm4yk/giphy.gif" height="200" align="middle">
