Feature: Functional Testing on Khan Academy Website

  Background: 
    Given user is on Homepage of Khan Academy

  Scenario: scroll down Homepage to the specific position
    When user scroll down the home page
    Then user should verify the right position

  Scenario: scroll up Homepage from the specific position
    When user scroll up the Homepage
    Then user should verify title of Homepage

  Scenario: complete signup process with valid credentials
    When user click on signup button
    And user should select date of birth
    And click on signup with Email button
    And user should fill Email "11aa22cc@gmail.com"
    And user fill first name "Billa"
    And user fill last name "Das"
    And user fill password "abc123!@#"
    And user click on signup button
    Then user should navigate to the login page

  Scenario: login with invalid credentials
    When user click on login button
    And user pass Email "110022cc@gmail.com"
    And user pass password "abc123!@#"
    And user click on login button
    Then user should not able to login

  Scenario: login with valid credentials
    When user click on login button
    And user pass Email "11aa22cc@gmail.com"
    And user pass password "abc123!@#"
    And user click on login button
    Then user should navigate to the student dashbord page

  Scenario: successful logout
    When user present on dashbord page
    And user click on dropdown
    And user click on logout button
    Then user should be logout

  Scenario: feature check of search box
    When user present on dashbord page
    And user click on searchbox
    And user write physics in searchbox
    Then user should see the result

  Scenario: specific video selection on physics
    When user show all the physics result
    And user click on video radio button
    And user select specific video
    Then user should go to video page

  Scenario: navigation of youtube page
    When user present on video page
    And user click on youtube button
    Then user should go to youtube page

  Scenario: video play and pause
    When user present on video page
    And user click on video
    And user click on pause button
    Then user should show video

  Scenario: check Explore dropdown
    When user present on dashbord page
    And click on Explore dropdown
    Then show all result in console
