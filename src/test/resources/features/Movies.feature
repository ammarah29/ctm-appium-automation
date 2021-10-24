@release
Feature: Movies
  As a customer
  I want to access the movies tab
  So that I can see upcoming movies

  @smoke
  Scenario: Successful member sign in
    Given I am a member and I sign in
    When I get past the post sign in screen
    Then I should get to the home screen

  Scenario: Successful access to meals membership card
    Given I am a member and I sign in
    When I open the rewards tab and navigate to meals
    Then I should be able to access meals membership card

  Scenario: Successful navigation to comparison tab
    Given I am a member and I sign in
    When I open the comparison tab
    Then I should be able to access my previous quotes
